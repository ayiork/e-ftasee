package com.example.e_ftasee.database

import android.provider.ContactsContract.CommonDataKinds.Note

import androidx.lifecycle.LiveData
import androidx.room.*

import com.example.e_ftasee.models.Order
import com.example.e_ftasee.models.OrderWithFood

@Dao
interface OrderDao {

    @Insert
    fun Insert(order: Order?)

    @Update
    fun  //(onConflict = OnConflictStrategy.REPLACE)
            Update(order: Order?)

    @Delete
    fun Delete(order: Order?)

    @Query("DELETE FROM orders_table")
    fun DeleteAllOrders()

    @Query("SELECT * FROM orders_table")
    fun getAllOrders(): LiveData<List<Order?>?>? //updates and returns

    @Transaction
    @Query("SELECT * FROM orders_table")
    fun getOrderWithFood():List<OrderWithFood>


}