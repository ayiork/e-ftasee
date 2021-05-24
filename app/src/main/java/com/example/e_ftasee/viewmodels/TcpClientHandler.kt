package com.example.e_ftasee.viewmodels

import android.os.Build
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.example.e_ftasee.models.ClientMessage
import com.example.e_ftasee.repository.MessageRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.io.DataInputStream
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//, private val rep: MessageRepository
class TcpClientHandler(private val dataInputStream: DataInputStream, private val rep : MessageRepository) : Thread() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun run() {
        while (true) {
            try {
                if(dataInputStream.available() > 0){
                    val msg = dataInputStream.readUTF()
                    val msgparts = msg.split(",").toTypedArray()
                    CoroutineScope(IO).launch {
                        rep.insertMessage(msgparts[0],msgparts[1])
                    }
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