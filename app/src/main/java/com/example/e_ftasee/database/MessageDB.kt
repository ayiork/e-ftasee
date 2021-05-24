package com.example.e_ftasee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.e_ftasee.models.ClientMessage

@Database(entities = [ClientMessage::class], version = 1, exportSchema = false)
abstract class MessageDB: RoomDatabase()  {

    abstract fun clientMessageDao(): MessageDao

    companion object {

        @Volatile
        private var INSTANCE: MessageDB? = null

        fun getClientMessageDatabase(context: Context): MessageDB? {
            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, MessageDB::class.java, "MESSAGES_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!
            }
                /*
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, MessageDB::class.java, "ClientMessage-database")
                    //.allowMainThreadQueries()
                    .build()
                }
                return INSTANCE

             */
            }
        }
}