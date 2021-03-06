package com.example.e_ftasee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.e_ftasee.models.Order

@Database(entities = [Order::class] , version = 1, exportSchema = false)
abstract class OrderDatabase : RoomDatabase() {
    abstract fun orderDao(): OrderDao

    companion object {
        private var INSTANCE: OrderDatabase? = null

        fun getOrderDatabase(context: Context): OrderDatabase?{
            if (INSTANCE != null){
                return INSTANCE
            }
            synchronized(this){
                INSTANCE = Room.databaseBuilder(context.applicationContext, OrderDatabase::class.java, "orders-database")
                    .fallbackToDestructiveMigration()
                    .build()
                return INSTANCE
            }

        }
    }
}