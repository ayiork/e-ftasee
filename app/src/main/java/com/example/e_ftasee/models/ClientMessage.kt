package com.example.e_ftasee.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName ="ClientMessages")
data class ClientMessage(

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "details")
    var details: String,

    @ColumnInfo(name = "date")
    var date: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "messageId")
    var messageId: Int? = null

}
