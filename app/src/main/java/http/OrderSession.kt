package http

import android.content.Context
import com.gqy.grpclient.R
import com.grpc.godemo.AppSignDeviceGrpcx
import com.supwisdom.orderlib.http.SessionAttribute
import io.grpc.ManagedChannel
import io.grpc.okhttp.OkHttpChannelBuilder
import java.io.InputStream
import java.security.KeyStore
import java.security.SecureRandom
import java.security.cert.CertificateFactory
import java.util.concurrent.TimeUnit
import javax.net.SocketFactory
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSession
import javax.net.ssl.TrustManagerFactory

/**
 * @author zzq
 * @date 2018/4/4.
 * @version 1.0.1
 * @desc  grpc通讯
 */
internal class OrderSession {
    companion object {
        val instance = OrderSession()
    }

    private val session = SessionAttribute()

    private var channel: ManagedChannel? = null

    fun setAgentIp(context: Context, ip: String) {
        if (ip != session.serverIp || channel == null) {
            channel?.enterIdle()
            session.serverIp = ip
//            session.serverPort = record.serverPort
            channel = buildChannel(context.resources.openRawResource(R.raw.certificate))
        }
    }

    fun setSessionKey(sessionKey: String) {
        this.session.sessionKey = sessionKey
    }

    fun getSessionKey(): String {
        return this.session.sessionKey
    }

    fun grpc(): AppSignDeviceGrpcx.AppSignDeviceBlockingStub {
        return AppSignDeviceGrpcx.newBlockingStub(channel!!)
            .withDeadlineAfter(3, TimeUnit.SECONDS)
    }

    private fun buildChannel(agentCrtFile: InputStream): ManagedChannel {
        val serverCertificate =
            CertificateFactory.getInstance("X.509").generateCertificate(agentCrtFile)
        val type = KeyStore.getDefaultType()
        val caKeyStore = KeyStore.getInstance(type).apply {
            load(null, null)
            setCertificateEntry("weighing_dc.supwisdom.com", serverCertificate)
        }

        val trustManagerFactory =
            TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm()).apply {
                init(caKeyStore)
            }

        val sslContext = SSLContext.getInstance("TLS").apply {
            init(null, trustManagerFactory.trustManagers, SecureRandom())
        }

        return OkHttpChannelBuilder
            .forAddress(session.serverIp, session.serverPort)
            .sslSocketFactory(sslContext.socketFactory)
            .socketFactory(SocketFactory.getDefault())
            .hostnameVerifier(TrustAllHostnameVerifier())
            .keepAliveTime(10, TimeUnit.SECONDS)
            .useTransportSecurity()
            .keepAliveWithoutCalls(false)
//            .idleTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    private class TrustAllHostnameVerifier : HostnameVerifier {
        override fun verify(
            hostname: String,
            session: SSLSession
        ): Boolean {
            return true
        }
    }
}