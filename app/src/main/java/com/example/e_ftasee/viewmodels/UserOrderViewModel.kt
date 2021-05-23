package com.example.e_ftasee.viewmodels
//
//import com.example.e_ftasee.models.Food
//import com.example.e_ftasee.models.Order
//import com.example.e_ftasee.repository.OrdersManager
//import androidx.databinding.ObservableField
//
//class UserOrderViewModel {
//
//    lateinit var OrdersManager : OrdersManager
//    var tableId: Int? = null
//    var order = ObservableField<Order>()
//
//    fun init(table_Id: Int){
//        this.tableId=table_Id
//        //order = OrdersManager.getOrder(table_Id)
//    }
//
//    fun insert(food: ArrayList<Food>){
//        OrdersManager.insertOrder(tableId!!,food)
//    }
//
//    fun update(food: ArrayList<Food>){
//        OrdersManager.insertOrder(tableId!!,food)
//    }
//
//}