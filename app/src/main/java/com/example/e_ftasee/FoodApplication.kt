package com.example.e_ftasee

import android.app.Application
import com.example.e_ftasee.database.OrderDatabase
import com.example.e_ftasee.repository.OrdersManager

class FoodApplication:Application() {

    val database by lazy{ OrderDatabase.getOrderDatabase(this)}
    val repository by lazy {OrdersManager(database!!.orderDao())}
}