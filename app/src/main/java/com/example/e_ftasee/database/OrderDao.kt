package com.example.e_ftasee.database

import android.provider.ContactsContract.CommonDataKinds.Note

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.e_ftasee.models.Food

import com.example.e_ftasee.models.Order


@Dao
interface OrderDao {

    @Insert
    fun Insert(order: Order?)

//    @Insert
//    fun InsertOrderWithFood(order: Order, food: List<Food>)

    @Update
    fun  //(onConflict = OnConflictStrategy.REPLACE)
            Update(order: Order?)

    @Delete
    fun Delete(order: Order?)

    @Query("DELETE FROM orders_table")
    fun deleteAllOrders()

//    @Query("SELECT * FROM orders_table")
//    fun getAllOrders(): LiveData<List<Order>> //updates and returns

    @Query("SELECT * FROM orders_table")
    fun getAllOrders(): List<Order> //updates and returns

    @Query("SELECT * FROM orders_table WHERE tableNum = :key")
    fun getOrder(key: Int): Order? //updates and returns

//    @Transaction
//    @Query("SELECT * FROM orders_table")
//    fun getOrderWithFood():List<OrderWithFood>


}