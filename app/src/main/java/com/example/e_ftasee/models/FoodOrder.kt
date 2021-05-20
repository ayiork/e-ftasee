package com.example.e_ftasee.models

import androidx.room.Entity

@Entity(primaryKeys = ["foodId","OrderId"])
data class FoodOrder (
    val foodId: Long,
    val OrderId: Long,
    val Quantity: Int
    )