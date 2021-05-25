package com.example.e_ftasee.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_ftasee.models.ClientMessage
import com.example.e_ftasee.repository.MessageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
class MessageViewModel: ViewModel() {

    lateinit var repositoryMsg: MessageRepository
    private lateinit var messagesList: LiveData<List<ClientMessage>>
    private var selected = MutableLiveData<Pair<Int, ClientMessage>>()


        fun init(){
            loadMessages()
        }

        // here can be added another int to show the amount of food
        fun getSelectedMessage(): LiveData<Pair<Int, ClientMessage>> {
            return selected
        }


        fun selectMessageAt(position: Int,msg: ClientMessage) {
            selected.value = Pair(position,msg)
        }

        fun getMessagesList():LiveData<List<ClientMessage>>{
            return messagesList
        }

        fun removeMessage(id:Int){
            viewModelScope.launch(Dispatchers.IO) {
                repositoryMsg.removeMessage(id)
            }
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