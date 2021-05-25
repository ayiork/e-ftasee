package com.example.e_ftasee.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_ftasee.models.Table
import com.example.e_ftasee.models.Admin
import com.example.e_ftasee.repository.TableRepository
import com.example.e_ftasee.repository.UsersRepository

class MainViewModel : ViewModel(){

    private val rep = TableRepository()
    private val repUsers = UsersRepository()
    private var tables: MutableList<Table>? = null
    private var admins:  MutableList<Admin>? = null
    private var table_id : MutableLiveData<Int> = MutableLiveData<Int>(0)
    private lateinit var client: Client

    //load tables' numbers and codes
    private fun loadTables(){
        tables = rep.getTables()
    }

    //Load admins' username and passwords
    private fun loadUsers(){
        admins = repUsers.getUsers()
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

    //return the table id
    fun givenID(): LiveData<Int>{
        return table_id
    }

    //authenticate a user
    fun auth(username: String, pass: String): Boolean{
        if (admins.isNullOrEmpty())
            loadUsers()
        for (user in admins!!)
            if (user.username==username && user.password==pass) {
                return true
            }
        return false
    }

    //send a message to the server
    fun sendMessage(table:Int, msg : String) {
        client.sendMsg(table, msg)
    }
}