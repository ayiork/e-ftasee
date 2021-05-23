package com.example.e_ftasee.repository

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.e_ftasee.database.OrderDao
import com.example.e_ftasee.models.Food
import com.example.e_ftasee.models.Order
import com.example.e_ftasee.models.Table
import com.example.e_ftasee.viewmodels.FoodViewModel

class OrdersManager(private val orderDao: OrderDao) {

    private var orders: List<Order> = orderDao.getAllOrders()
    private var order: Order? = null
    //private val foodViewModel: FoodViewModel by activityViewModels()

//    init{
//        if (orders.isEmpty()) {
////            val food:ArrayList<Food> = ArrayList()
////            food.add(foodViewModel.getFoodById(4)!!)
////            val food2:ArrayList<Food> = ArrayList()
////            food2.add(foodViewModel.getFoodById(3)!!)
////            food2.add(foodViewModel.getFoodById(2)!!)
////            orders.add(Order(tableNum = 5, details = "Mix\nSouvlaki\nLoukaniko",food =food))
////            orders.add(Order(tableNum = 2,details =  "Pitta Xalloumi\nSouvlaki\nLoukaniko",food = food2))
//        }
//    }

    fun getOrder(id:Int):Order?{
        return orderDao.getOrder(id)
    }

//    fun getOrdersNames(): Array<String?> {
//        val names = arrayOfNulls<String>(orders.size)
//
//        orders.forEachIndexed { i, order ->
//            names[i] = order.details
//        }
//        return names
//    }
//
    fun getOrders(): List<Order>{
        return orders;
    }

    fun getOrdersNames(): Array<Int?> {
        orders=orderDao.getAllOrders()
        val tableNums = arrayOfNulls<Int>(orders.size)
        orders.forEachIndexed { i, order ->
            tableNums[i] = order.tableNum
        }
        return tableNums
    }

    /*
    fun insertOrder(table : Int,food: ArrayList<Food>){
     var foodStr: String = ""
            var totalPrice: Double = 0.0
            food.forEachIndexed { i, food ->
                foodStr += food.name + "\n"
                totalPrice += food.price
                orderDao.Insert(Order(tableNum = table,details=foodStr,totalPrice = totalPrice))
                }
     */
    fun updateOrder(table : Int,food: Food){
       // var tableOrder = "Table $table"
        if (order==null){
            var foodStr: String = food.name+"\n"
            var totalPrice: Double = food.price

            order = Order(tableNum = table, details = foodStr, totalPrice = totalPrice)
        }else {
            order!!.details+= food.name +"\n"
            order!!.totalPrice+=food.price
            }
        // THIS WILL BE CALLED WHEN PLACE ORDER BUTTON WILL BE PRESSED
        insertOrderToDB()

    }
    fun insertOrderToDB(){
        orderDao.Insert(order)
    }
    fun deleteOrders(){
        orderDao.deleteAllOrders()
    }

}

