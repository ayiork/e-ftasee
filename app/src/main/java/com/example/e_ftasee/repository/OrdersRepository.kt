package com.example.e_ftasee.repository

import androidx.lifecycle.LiveData
import com.example.e_ftasee.database.OrderDao
import com.example.e_ftasee.models.Food
import com.example.e_ftasee.models.Order

class OrdersRepository(private val orderDao: OrderDao) {

    private var orders: LiveData<List<Order>> = orderDao.getAllOrders()
    private var order: Order? = null

    //returns my order
    fun getMyOrder(id:Int):Order?{
        if (order != null && order!!.tableNum == id) {
            return order
        }else
            return null
    }

    //returns a list of orders
    fun getOrders(): LiveData<List<Order>>{
        return orders
    }

    //update
    fun updateOrder(table : Int,food: Food){
        if (order==null || order!!.tableNum != table){
            var foodStr: String = food.name+"\n"
            var totalPrice: Double = food.price
            order = Order(tableNum = table, details = foodStr, totalPrice = totalPrice)
        }else {
            order!!.details+= food.name +"\n"
            order!!.totalPrice+=food.price
            }
    }

    //insert order to db
    suspend fun insertOrderToDB(){
        if (order!=null)
            orderDao.Insert(order)
    }

    //delete my order
    suspend fun deleteMyOrder(){
        order = null
    }

    //delete all orders
    fun deleteOrders(){
        orderDao.deleteAllOrders()
    }

}

