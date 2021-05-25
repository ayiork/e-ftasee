package com.example.e_ftasee.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_ftasee.models.ClientMessage
import com.example.e_ftasee.models.Table
import com.example.e_ftasee.models.User
import com.example.e_ftasee.repository.TableRepository
import com.example.e_ftasee.repository.UsersRepository

class MainViewModel : ViewModel(){

    private val rep = TableRepository()
    private val repUsers = UsersRepository()
    private var tables: MutableList<Table>? = null
    private var users:  MutableList<User>? = null
    private var table_id : MutableLiveData<Int> = MutableLiveData<Int>(0)
    private lateinit var userRest : String
    private lateinit var client: Client


    private fun loadTables(){
        tables = rep.getTables()
    }

    private fun loadUsers(){
        users = repUsers.getUsers()
    }

    //the table is verified by the code (in the future with a code from QR code)
    fun tableCode(userCode: Int): Boolean{
        if (tables.isNullOrEmpty())
            loadTables()
        for (table in tables!!)
            if (table.code==userCode) {
                table_id = MutableLiveData<Int>(table.id)
                client = Client()
                return true
            }
        return false
    }

    fun givenID(): LiveData<Int>{
        return table_id
    }

    fun auth(username: String, pass: String): Boolean{
        if (users.isNullOrEmpty())
            loadUsers()
        for (user in users!!)
            if (user.username==username && user.password==pass) {
                userRest = user.fullname
                return true
            }
        return false
    }

    fun sendMessage(table:Int, msg : String) {
        client.sendMsg(table, msg)
    }
}