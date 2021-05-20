package com.example.e_ftasee.repository

import androidx.fragment.app.activityViewModels
import com.example.e_ftasee.models.Food
import com.example.e_ftasee.models.Order
import com.example.e_ftasee.models.Table
import com.example.e_ftasee.viewmodels.FoodViewModel

class OrdersManager {

    private val orders: ArrayList<Order> = ArrayList()
    //private val foodViewModel: FoodViewModel by activityViewModels()

    init{
        if (orders.isEmpty()) {
//            val food:ArrayList<Food> = ArrayList()
//            food.add(foodViewModel.getFoodById(4)!!)
//            val food2:ArrayList<Food> = ArrayList()
//            food2.add(foodViewModel.getFoodById(3)!!)
//            food2.add(foodViewModel.getFoodById(2)!!)
//            orders.add(Order(tableNum = 5, details = "Mix\nSouvlaki\nLoukaniko",food =food))
//            orders.add(Order(tableNum = 2,details =  "Pitta Xalloumi\nSouvlaki\nLoukaniko",food = food2))
        }
    }


    fun getOrdersNames(): Array<String?> {
        val names = arrayOfNulls<String>(orders.size)

        orders.forEachIndexed { i, order ->
            names[i] = order.details
        }
        return names
    }

    fun getOrdes():  ArrayList<Order>{
        return orders;
    }

    fun addOrder(table : Int, det: String,food: ArrayList<Food>){
        var tableOrder = "Table $table"
        orders.add(Order(tableNum = table,details = det,food = food))
    }

}

