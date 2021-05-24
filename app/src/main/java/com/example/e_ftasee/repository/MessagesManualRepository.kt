package com.example.e_ftasee.repository

import android.content.Context
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import com.example.e_ftasee.models.ClientMessage
import com.example.e_ftasee.models.Food
import com.example.e_ftasee.models.Order
import com.example.e_ftasee.models.Table
import com.example.e_ftasee.viewmodels.Client
import com.example.e_ftasee.viewmodels.FoodViewModel

class MessagesManualRepository(context: Context) {

    private val appContext=context

    // a list of all restaurant's tables
    private val messages: MutableList<ClientMessage> = ArrayList()

    //instead of these, we can use a db service such as firestone
    init {
        //insertData(applicationContext)
        if (messages.isEmpty()){
            insertData("Order 1 - Table 3","Mix\nPitta Xalloumi","23-5-2021")
            insertData("Order 2 - Table 5","Mix\nPitta Xalloumi","23-5-2021")
            insertData("Order 3 - Table 9","Mix\nPitta Xalloumi","23-5-2021")
            insertData("Order 4 - Table 10","Mix\nPitta Xalloumi","23-5-2021")
            insertData("Order 5 - Table 1","Mix\nPitta Xalloumi","23-5-2021")
            insertData("Order 6 - Table 2","Mix\nPitta Xalloumi","23-5-2021")
            insertData("Order 7 - Table 3","Mix\nPitta Xalloumi","23-5-2021")
            insertData("Order 8 - Table 4","Mix\nPitta Xalloumi","23-5-2021")
            insertData("Order 9 - Table 6","Mix\nPitta Xalloumi","23-5-2021")
            insertData("Order 10 - Table 5","Mix\nPitta Xalloumi","23-5-2021")
            insertData("Order 11 - Table 2","Mix\nPitta Xalloumi","23-5-2021")
        }
    }

    private var liveDataMsg: LiveData<ClientMessage>? = null

    fun insertData(name: String, details: String,date: String)  {
        appContext?.let { MessageRepository.insertData(it, name, details,date) }
    }

    fun getMessageDetails(context: Context, id: Int) : LiveData<ClientMessage>? {
        liveDataMsg = appContext?.let { MessageRepository.getMessageDetails(it, id) }
        return liveDataMsg
    }

    fun getMessagesNames(): Array<String?> {
        val names = arrayOfNulls<String>(messages.size)

        messages.forEachIndexed { i, order ->
            names[i] = order.name
        }
        return names
    }

    fun getMessages():  MutableList<ClientMessage>{
        return messages;
    }

}

