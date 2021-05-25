package com.example.e_ftasee.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.e_ftasee.models.ClientMessage


@Dao
interface MessageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(clientMessage: ClientMessage?)

    @Query("DELETE FROM ClientMessages where messageId =:msgID")
    suspend fun delete(msgID: Int)

    @Query("SELECT COUNT(*) from ClientMessages")
    fun countUsers(): Int

    @Query("SELECT * FROM ClientMessages where messageId = :id")
    fun getMessage(id: Int): LiveData<ClientMessage>

    @Query("SELECT * FROM ClientMessages where date = :date ")
    fun getDateMessages(date: String): LiveData<List<ClientMessage>>

}