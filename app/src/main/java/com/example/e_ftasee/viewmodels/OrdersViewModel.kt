package com.example.e_ftasee.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_ftasee.models.Food
import com.example.e_ftasee.models.Order
import com.example.e_ftasee.repository.FoodManager
import com.example.e_ftasee.repository.OrdersManager
import kotlin.collections.ArrayList

class OrdersViewModel: ViewModel() {

    private lateinit var ordersList: ArrayList<Order>
    private lateinit var ordersNames: Array<String?>
    private var selected = MutableLiveData<Pair<Int, Order>>()
    private val OrdersManager = OrdersManager()

    init{
        loadOrder()
        loadOrderNames()
    }

    // here can be added another int to show the amount of food
    fun getSelectedFood(): LiveData<Pair<Int, Order>> {
        return selected
    }

    fun selectOrderAt(position: Int) {
        //Log.i("selectfood", selectedFood.value.toString());
        selected.value = Pair(position, ordersList[position])
    }

    fun getOrdersNames(): Array<String?>{
        return ordersNames
    }

    private fun loadOrderNames(){
        ordersNames = OrdersManager.getOrdersNames()
    }

    private fun loadOrder(){
        ordersList= OrdersManager.getOrdes()
    }
}