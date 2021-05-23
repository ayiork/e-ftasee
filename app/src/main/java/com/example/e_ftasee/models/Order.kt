package com.example.e_ftasee.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="orders_table")
data class Order(
    @PrimaryKey(autoGenerate = true)
    var orderId: Long = 0L,
    //@ColumnInfo(name = "table")
    @JvmField
    var tableNum: Int,
    @ColumnInfo(name = "food")
    var details: String,
    @ColumnInfo(name = "price")
    var totalPrice: Double,

//    @Embedded()
//    var food: ArrayList<Food>
)


