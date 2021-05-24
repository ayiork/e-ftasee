package com.example.e_ftasee.viewmodels

import java.io.DataOutputStream
import java.io.IOException
import java.io.OutputStream
import java.net.InetAddress
import java.net.Socket
import java.net.UnknownHostException
import java.nio.charset.Charset
import java.util.*
import kotlin.concurrent.thread

class Client {

    private var socket: Socket? = null
    private var msg= "Hello love"

    companion object {
        private const val SERVERPORT = 9999
        //private const val SERVER_IP = "127.0.0.1"
        private const val SERVER_IP = "192.168.1.105"
        var counter = 1
    }

    fun sendMsg(table: Int,message: String){
        //Order $counter
        msg= "Table $table ,$message"
        counter++
        Thread(ClientThread()).start()
    }


    internal inner class ClientThread : Runnable {
        override fun run() {
            try {
                val serverAddr: InetAddress =
                    InetAddress.getByName(SERVER_IP)
                socket = Socket(serverAddr, SERVERPORT)
                val dataOutputStream = DataOutputStream(socket!!.getOutputStream())
                dataOutputStream.writeUTF(msg)
                socket!!.close()
            } catch (e1: UnknownHostException) {
                e1.printStackTrace()
            } catch (e1: IOException) {
                e1.printStackTrace()
            }
        }
    }

}