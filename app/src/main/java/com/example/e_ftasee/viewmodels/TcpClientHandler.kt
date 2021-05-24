package com.example.e_ftasee.viewmodels

import android.util.Log
import java.io.DataInputStream
import java.io.IOException

//, private val rep: MessageRepository
class TcpClientHandler(private val dataInputStream: DataInputStream) : Thread() {

    //val msgs: ArrayList<String> = ArrayList()

    override fun run() {
        while (true) {
            try {
                if(dataInputStream.available() > 0){
                    val msg = dataInputStream.readUTF()
                    /*
                    val msgparts = msg.split(",").toTypedArray()
                    val current = LocalDateTime.now()
                    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                    val formatted = current.format(formatter).toString()

                    var message: ClientMessage = ClientMessage(msgparts[0],msgparts[1],formatted)
                    rep.insert(message)
                    */
                    Log.i(TAG, "Received: $msg")
                    sleep(2000L)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                try {
                    dataInputStream.close()
                } catch (ex: IOException) {
                    ex.printStackTrace()
                }
            }
        }
    }

    companion object {
        private val TAG = TcpClientHandler::class.java.simpleName
    }

}