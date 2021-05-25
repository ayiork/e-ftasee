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

    // This functions are not used because they are supposed to be used when a database (ex. firebase)
    // will be used for communicating


    // return a pair that is the selected Order and its position
    fun getSelectedOrder(): LiveData<Pair<Int, Order>> {
        return selected
    }

    // select the order at the given position
    fun selectOrderAt(position: Int,ord:Order) {
        selected.value = Pair(position,ord)
    }

    //return a list that contains all the orders that are in the db
    fun getOrdersList():LiveData<List<Order>>{
        return ordersList
    }

    //return the order for the given tableId
    fun getMyOrder(tableId: Int):Order?{
       return repository.getMyOrder(tableId)
    }

    // insert given Food into the order of the given table ID
    fun insert(food: Food,tableId:Int){
        repository.updateOrder(tableId!!,food)
    }

    // place the order that the user has created for the given table ID
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

    // delete the order that the user has created for the given table ID
    fun deleteOrder(tableId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            var order = getMyOrder(tableId)
            var msg = order?.details + order?.totalPrice.toString()
            if (msg != null) {
                repository.deleteMyOrder()
            }
        }
    }

    // load all the orders in the livedata list of the view model
    private fun loadOrders(){
        ordersList= repository.getOrders()
    }


    // call the appropriate function to delete all Orders from the database
    fun deleteOrders(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteOrders()
        }
    }
}