package com.example.e_ftasee.viewmodels

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.e_ftasee.models.ClientMessage
import java.io.DataInputStream
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//, private val rep: MessageRepository
class TcpClientHandler(private val dataInputStream: DataInputStream) : Thread() {

    //val msgs: ArrayList<String> = ArrayList()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun run() {
        while (true) {
            try {
                if(dataInputStream.available() > 0){
                    val msg = dataInputStream.readUTF()
                    val msgparts = msg.split(",").toTypedArray()
                    val current = LocalDateTime.now()
                    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                    val formatted = current.format(formatter).toString()
                    var message: ClientMessage = ClientMessage(msgparts[0],msgparts[1],formatted)
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