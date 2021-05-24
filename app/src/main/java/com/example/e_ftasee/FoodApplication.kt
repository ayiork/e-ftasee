package com.example.e_ftasee

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import com.example.e_ftasee.database.MessageDB
import com.example.e_ftasee.database.OrderDatabase
import com.example.e_ftasee.repository.MessageRepository
import com.example.e_ftasee.repository.OrdersManager

@RequiresApi(Build.VERSION_CODES.O)
class FoodApplication:Application() {

    val database by lazy{ OrderDatabase.getOrderDatabase(this)}
    val repository by lazy {OrdersManager(database!!.orderDao())}
    val databaseMsg by lazy{ MessageDB.getMessageDatabase(this)}
    val repositoryMsg by lazy {MessageRepository(databaseMsg!!.messageDao())}
}