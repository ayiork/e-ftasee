package com.example.e_ftasee.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// maybe name must be value?
@Entity(tableName ="orders_table")
data class Food(
    @PrimaryKey(autoGenerate = true)
    var foodId: Long = 0L,
    @ColumnInfo(name = "food_name")
    var name: String,
    @ColumnInfo(name = "food_details")
    var details: String
    //maybe also a num for food number
    )