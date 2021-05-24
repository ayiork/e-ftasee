package com.example.e_ftasee.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.e_ftasee.models.ClientMessage

@Database(entities = [ClientMessage::class], version = 1, exportSchema = false)
abstract class MessageDB: RoomDatabase()  {

    abstract fun messageDao(): MessageDao

    companion object {
        // Singleton to prevent multiple instances from existing
        private var INSTANCE: MessageDB? = null

        fun getMessageDatabase(context: Context): MessageDB?{
            if (INSTANCE != null){
                return INSTANCE
            }
            synchronized(this){
                INSTANCE = Room.databaseBuilder(context.applicationContext, MessageDB::class.java, "messages-database")
                    // Allow queries on the main thread.
                    // Don't do this on a real app!
                    //.allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                //Log.i("messageDB","synchronized instance")
                return INSTANCE
            }

        }
    }
}