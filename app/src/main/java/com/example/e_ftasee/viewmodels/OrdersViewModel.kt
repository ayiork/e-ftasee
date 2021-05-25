package com.example.e_ftasee.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_ftasee.models.Food
import com.example.e_ftasee.models.Order
import com.example.e_ftasee.repository.OrdersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OrdersViewModel: ViewModel() {

    lateinit var repository: OrdersRepository
    private lateinit var ordersList: LiveData<List<Order>>
    private var selected = MutableLiveData<Pair<Int, Order>>()
    private var client: Client = Client()


    fun init(){
        loadOrders()
    }

    // here can be added another int to show the amount of food
    fun getSelectedFood(): LiveData<Pair<Int, Order>> {
        return selected
    }

    fun selectOrderAt(position: Int,ord:Order) {
        selected.value = Pair(position,ord)
    }

    fun getOrdersList():LiveData<List<Order>>{
        return ordersList
    }

    fun getMyOrder(tableId: Int):Order?{
       return repository.getMyOrder(tableId)
    }

    fun insert(food: Food,tableId:Int){
        repository.updateOrder(tableId!!,food)
    }

    fun placeOrder(tableId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            var order = getMyOrder(tableId)
            var msg = order?.details + order?.totalPrice.toString()
            if (msg != null) {

                client.sendMsg(tableId, msg)
                repository.insertOrderToDB()
            }
        }
    }
    private fun loadOrders(){
        ordersList= repository.getOrders()
    }

    fun deleteOrders(){
        repository.deleteOrders()
    }
}