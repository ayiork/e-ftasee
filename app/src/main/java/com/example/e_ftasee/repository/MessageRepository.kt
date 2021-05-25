package com.example.e_ftasee.repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.example.e_ftasee.database.MessageDao
import com.example.e_ftasee.models.ClientMessage
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class MessageRepository(private val messageDao: MessageDao) {

    //only today messages will be shown up
    private var messages:LiveData<List<ClientMessage>>

    init{
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formatted = current.format(formatter).toString()
        messages = messageDao.getDateMessages(formatted)
    }

    //returns a list of messages
    fun getMessages():LiveData<List<ClientMessage>>{
        return messages
    }

    //insert a message to db, the date of the msg is the current day
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