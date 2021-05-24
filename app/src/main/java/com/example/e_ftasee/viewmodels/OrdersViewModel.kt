package com.example.e_ftasee.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_ftasee.models.Food
import com.example.e_ftasee.models.Order
import com.example.e_ftasee.repository.OrdersManager
import kotlin.collections.ArrayList

class OrdersViewModel: ViewModel() {

    lateinit var repository: OrdersManager
    private var ordersList: List<Order>  = ArrayList()
    private lateinit var ordersTables: Array<Int?>
    private var selected = MutableLiveData<Pair<Int, Order>>()


    fun init(){
        //deleteOrders()
        loadOrders()
        loadOrderNames()
    }

    // here can be added another int to show the amount of food
    fun getSelectedFood(): LiveData<Pair<Int, Order>> {
        return selected
    }

    fun selectOrderAt(position: Int) {
        //Log.i("selectfood", selectedFood.value.toString());
        loadOrders()
        selected.value = Pair(position, ordersList[position])
    }

    private fun tableName(num:Int):String{
        return "Order table: $num"
    }
    fun getOrdersNames(): Array<String?> {
        ordersTables = repository.getOrdersNames()
        Log.i("orderames",ordersTables.toString())
        return Array(ordersTables.size) { i -> tableName(ordersTables[i]!!) }
    }

    fun getMyOrder(tableId: Int):Order?{
       return repository.getMyOrder(tableId)
    }

    // USERORDERVIEWMODEL
    fun insert(food: Food,tableId:Int){
        repository.updateOrder(tableId!!,food)
    }

    private fun loadOrderNames(){
        ordersTables = repository.getOrdersNames()
    }

    fun placeOrder(){
        repository.insertOrderToDB()
    }
    private fun loadOrders(){
        ordersList= repository.getOrders()
    }

    fun deleteOrders(){
        repository.deleteOrders()
    }
}