package com.example.e_ftasee.database

import androidx.lifecycle.LiveData
import androidx.room.*

import com.example.e_ftasee.models.Order


@Dao
interface OrderDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insert(order: Order?)

    @Delete
    fun Delete(order: Order?)

    @Query("DELETE FROM orders_table")
    fun deleteAllOrders()

    @Query("SELECT * FROM orders_table")
    fun getAllOrders(): LiveData<List<Order>> //updates and returns

    @Query("SELECT * FROM orders_table WHERE tableNum = :key")
    fun getOrder(key: Int): Order? //updates and returns

}