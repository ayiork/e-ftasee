package com.example.e_ftasee.viewmodels

import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_ftasee.models.Table
import com.example.e_ftasee.repository.TableRepository

class MainViewModel : ViewModel(){

    private val rep = TableRepository()
    private lateinit var tables:  MutableList<Table>
    private var table_id : MutableLiveData<Int>


    init{
        table_id = MutableLiveData<Int>(0)
        loadTables()
    }

    private fun loadTables(){
        tables = rep.getTables()
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

}