package com.example.e_ftasee.repository

import androidx.lifecycle.LiveData
import com.example.e_ftasee.database.OrderDao
import com.example.e_ftasee.models.Food
import com.example.e_ftasee.models.Order

class OrdersManager(private val orderDao: OrderDao) {

    private var orders: LiveData<List<Order>> = orderDao.getAllOrders()
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

    //    id:Int
    fun getMyOrder(id:Int):Order?{
        //return orderDao.getOrder(id)
        if (order != null && order!!.tableNum == id) {
            return order
        }else
            return null

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
    fun getOrders(): LiveData<List<Order>>{
        //orders= orderDao.getAllOrders()
        return orders
    }

//    fun getOrdersNames(): Array<Int?> {
//        //orders=orderDao.getAllOrders()
//        val tableNums = arrayOfNulls<Int>(orders.size)
//        orders.forEachIndexed { i, order ->
//            tableNums[i] = order.tableNum
//        }
//        return tableNums
//    }

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
        if (order==null || order!!.tableNum != table){
            var foodStr: String = food.name+"\n"
            var totalPrice: Double = food.price

            order = Order(tableNum = table, details = foodStr, totalPrice = totalPrice)
        }else {
            order!!.details+= food.name +"\n"
            order!!.totalPrice+=food.price
            }
        // THIS WILL BE CALLED WHEN PLACE ORDER BUTTON WILL BE PRESSED
        //insertOrderToDB()

    }
    suspend fun insertOrderToDB(){
        orderDao.Insert(order)
    }
    fun deleteMyOrder(){
        order = null
    }
    fun deleteOrders(){
        orderDao.deleteAllOrders()
    }

}

