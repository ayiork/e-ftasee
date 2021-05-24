package com.example.e_ftasee.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.e_ftasee.models.ClientMessage


@Dao
interface MessageDao {


//    @Update
//    fun update(clientMessage: ClientMessage): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(clientMessage: ClientMessage?)

    @Query("SELECT COUNT(*) from ClientMessages")
    fun countUsers(): Int
    
    @Query("SELECT * FROM ClientMessages where messageId = :id")
    fun getMessage(id: Int): LiveData<ClientMessage>

    @Query("SELECT * FROM ClientMessages where date = :date ")
    fun getDateMessages(date: String): LiveData<List<ClientMessage>>

}