package com.example.e_ftasee.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.e_ftasee.models.ClientMessage


@Dao
interface MessageDao {

    @Query("SELECT * FROM ClientMessages where messageId = :id")
    fun getMessage(id: Int): LiveData<ClientMessage>

    @Update
    fun update(clientMessage: ClientMessage): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(clientMessage: ClientMessage)

    @Query("SELECT COUNT(*) from ClientMessages")
    fun countUsers(): Int

}