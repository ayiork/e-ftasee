package com.example.e_ftasee.viewmodels

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.e_ftasee.FoodApplication
import com.example.e_ftasee.R
import com.example.e_ftasee.repository.MessageRepository
import com.example.e_ftasee.views.MainActivity
import java.io.DataInputStream
import java.io.IOException
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.atomic.AtomicBoolean

class TcpServerService : Service() {

        private var serverSocket: ServerSocket? = null
        private val working = AtomicBoolean(true)
        private lateinit var repositoryMsg: MessageRepository

        private val runnable = Runnable {
            var socket: Socket? = null
            try {
                repositoryMsg = (application as FoodApplication).repositoryMsg
                serverSocket = ServerSocket(PORT)
                while (working.get()) {
                    if (serverSocket != null) {
                        socket = serverSocket!!.accept()
                        Log.i("Server","New client: $socket")
                        val dataInputStream = DataInputStream(socket.getInputStream())
                        val t: Thread = TcpClientHandler(dataInputStream,repositoryMsg)
                        t.start()
                    }
                }
            } catch (e: IOException) {
                //e.printStackTrace()
                try {
                    socket?.close()
                } catch (ex: IOException) {
                    //ex.printStackTrace()
                }
            }
        }

        /*
         val dataOutputStream = DataOutputStream(socket.getOutputStream())
        , dataOutputStream
        //dataOutputStream.writeUTF("Hello Client")
         */

        override fun onBind(intent: Intent): IBinder? {
            return null
        }

        override fun onCreate() {
            startMeForeground()
            Thread(runnable).start()
        }

        override fun onDestroy() {
            working.set(false)
        }

        private fun startMeForeground() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val NOTIFICATION_CHANNEL_ID = packageName
                val channelName = "Tcp Server Background Service"
                val chan = NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_NONE)
                chan.lightColor = Color.BLUE
                chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
                val manager = (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
                manager.createNotificationChannel(chan)
                val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                val notification = notificationBuilder.setOngoing(true)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("e-ftasee is running in background, you can receive messages/orders from your clients")
                    .setPriority(NotificationManager.IMPORTANCE_MIN)
                    .setCategory(Notification.CATEGORY_SERVICE)
                    .build()
                startForeground(2, notification)
            } else {
                startForeground(1, Notification())
            }
        }

        companion object {
            //private val TAG = TcpServerService::class.java.simpleName
            private const val PORT = 9999
        }
}