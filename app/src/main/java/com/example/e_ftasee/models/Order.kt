package com.example.e_ftasee.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="orders_table")
data class Order(
    @PrimaryKey(autoGenerate = true)
    var OrderId: Long = 0L,
    @ColumnInfo(name = "table")
    var tableNum: Int,
    @ColumnInfo(name = "details")
    var details: String,
    @Embedded()
    var food: ArrayList<Food>
)


