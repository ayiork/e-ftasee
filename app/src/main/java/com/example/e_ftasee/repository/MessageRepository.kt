package com.example.e_ftasee.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.e_ftasee.database.MessageDB
import com.example.e_ftasee.models.ClientMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

//private val messageDao: MessageDao
class MessageRepository() {

    /*
    fun getMessages(): ClientMessage {
        return messageDao.getMessage()
    }

    fun insert(clientMessage: ClientMessage) {
        messageDao.insert(clientMessage)
    }

    fun count(): Int {
        return messageDao.countUsers()
    }

    fun update(clientMessage: ClientMessage) {
        messageDao.update(clientMessage)
    }
    */
    companion object {

        var messageDatabase: MessageDB? = null

        var clientMsg: LiveData<ClientMessage>? = null

        fun initializeDB(context: Context) : MessageDB? {
            return MessageDB.getClientMessageDatabase(context)
        }

        fun insertData(context: Context, name: String, details: String,date: String) {

            messageDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                val msg = ClientMessage(name, details,date)
                messageDatabase!!.clientMessageDao().insert(msg)
            }

        }

        fun getMessageDetails(context: Context, id: Int) : LiveData<ClientMessage>? {

            messageDatabase = initializeDB(context)

            clientMsg = messageDatabase!!.clientMessageDao().getMessage(id)

            return clientMsg
        }

    }


}