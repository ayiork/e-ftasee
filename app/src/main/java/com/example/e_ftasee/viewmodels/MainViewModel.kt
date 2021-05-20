package com.example.e_ftasee.viewmodels

import android.content.Intent
import android.os.Build
import android.text.Editable
import android.util.Log
import androidx.core.content.ContextCompat.startForegroundService
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_ftasee.models.Table
import com.example.e_ftasee.models.User
import com.example.e_ftasee.repository.TableRepository
import com.example.e_ftasee.repository.UsersRepository
import java.io.*
import java.net.InetAddress
import java.net.Socket
import java.net.UnknownHostException
import java.util.logging.Handler

class MainViewModel : ViewModel(){

    private val rep = TableRepository()
    private val repUsers = UsersRepository()
    private lateinit var tables:  MutableList<Table>
    private lateinit var users:  MutableList<User>
    private var table_id : MutableLiveData<Int>
    private var user_rest : String = "None"
    private val client: Client = Client()

    init{
        table_id = MutableLiveData<Int>(0)
        loadTables()
        loadUsers()
    }

    private fun loadTables(){
        tables = rep.getTables()
    }

    private fun loadUsers(){
        users = repUsers.getUsers()
    }

    //the table is verified by the code (in the future with a code from QR code)
    fun tableCode(userCode: Int): Boolean{
        for (table in tables)
            if (table.code==userCode) {
                table_id = MutableLiveData<Int>(table.id)
                return true
            }
        return false
    }

    fun givenID(): LiveData<Int>{
        return table_id
    }

    fun auth(username: String, pass: String): Boolean{
        for (user in users)
            if (user.username==username && user.password==pass) {
                user_rest = user.fullname
                return true
            }
        return false
    }

    fun sendMessage(msg : String) {
        client.sendMsg(msg)
    }


}