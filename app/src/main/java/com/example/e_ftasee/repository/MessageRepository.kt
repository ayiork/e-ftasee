package com.example.e_ftasee.repository

import android.content.Context
import android.os.Build
import android.telecom.Call
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.example.e_ftasee.database.MessageDB
import com.example.e_ftasee.database.MessageDao
import com.example.e_ftasee.database.OrderDao
import com.example.e_ftasee.models.ClientMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//private val messageDao: MessageDao
@RequiresApi(Build.VERSION_CODES.O)
class MessageRepository(private val messageDao: MessageDao) {
    private lateinit var messages:LiveData<List<ClientMessage>>

    init{
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formatted = current.format(formatter).toString()
        messages = messageDao.getDateMessages(formatted)
    }

    fun getMessages():LiveData<List<ClientMessage>>{
        return messages
    }

    suspend fun insertMessage(name: String,details: String){
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formatted = current.format(formatter).toString()
        var msg = ClientMessage(name= name,details= details,date= formatted)
        messageDao.insert(msg)
    }
    suspend fun removeMessage(id:Int){
        messageDao.delete(id)
    }

}