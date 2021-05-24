package com.example.e_ftasee.viewmodels

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_ftasee.models.ClientMessage
import com.example.e_ftasee.models.Food
import com.example.e_ftasee.models.Order
import com.example.e_ftasee.repository.MessageRepository
import com.example.e_ftasee.repository.OrdersManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
class MessageViewModel: ViewModel() {

    lateinit var repositoryMsg: MessageRepository
    private lateinit var messagesList: LiveData<List<ClientMessage>>
    private var selected = MutableLiveData<Pair<Int, ClientMessage>>()


        fun init(){
            loadMessages()
            insert("table 5","Thelw kafeee")
            insert("table 6","Thelw nargile")
        }

        // here can be added another int to show the amount of food
        fun getSelectedMessage(): LiveData<Pair<Int, ClientMessage>> {
            return selected
        }


        fun selectMessageAt(position: Int,msg: ClientMessage) {
            //Log.i("selectfood", selectedFood.value.toString());
            //loadOrders()
            selected.value = Pair(position,msg)
        }


//        fun getOrdersList(): LiveData<List<Order>> {
//            return ordersList
//        }
//
//        fun getMyOrder(tableId: Int): Order?{
//            return repository.getMyOrder(tableId)
//        }

        fun getMessagesList():LiveData<List<ClientMessage>>{
            return messagesList
        }

        fun insert(name: String, details:String){
            viewModelScope.launch(Dispatchers.IO) {
                repositoryMsg.insertMessage(name,details)
            }
        }
        private fun loadMessages(){
            messagesList= repositoryMsg.getMessages()
        }

    }