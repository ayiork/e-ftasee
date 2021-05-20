package com.example.e_ftasee.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.e_ftasee.models.Order

@Database(entities = [Order::class] , version = 1, exportSchema = false)
abstract class OrderDatabase : RoomDatabase() {
    private val instance: OrderDatabase? = null
}