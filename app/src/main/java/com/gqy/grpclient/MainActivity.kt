package com.gqy.grpclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.grpc.godemo.GoGrpcUtilx
import http.OrderSession
import http.ThreadPool

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        OrderSession.instance.setAgentIp(this, "192.168.157.208")
        findViewById<View>(R.id.tv_send).setOnClickListener {
            doSignin()
        }
    }

    private fun doSignin() {
        ThreadPool.getShortPool().execute {
            val req = GoGrpcUtilx.AppSign.newBuilder()
                .setDevphyid("001")
                .build()
            val resp = OrderSession.instance.grpc().signin(req)
            Log.e(TAG, "收到相应：" + resp.retcode + "," + resp.retmsg)
        }
    }
}