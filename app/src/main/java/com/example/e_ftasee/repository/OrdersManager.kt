package com.example.e_ftasee.repository

import com.example.e_ftasee.models.Order
import com.example.e_ftasee.models.Table

class OrdersManager {

    private val orders: ArrayList<Order> = ArrayList()

    init{
        if (orders.isEmpty()) {
            orders.add(Order("Table 5", "Mix\nSouvlaki\nLoukaniko"))
            orders.add(Order("Table 3", "Pitta Xalloumi\nSouvlaki\nLoukaniko"))
        }
    }


    fun getOrdersNames(): Array<String?> {
        val names = arrayOfNulls<String>(orders.size)

        orders.forEachIndexed { i, order ->
            names[i] = order.name
        }
        return names
    }

    fun getOrdes():  ArrayList<Order>{
        return orders;
    }

    fun addOrder(table : Int, det: String){
        var tableOrder = "Table $table"
        orders.add(Order(tableOrder,det))
    }

}

