package com.example.e_ftasee.models

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
//
//data class OrderWithFood (
//    @Embedded val order:Order,
//    @Relation(
//        parentColumn = "orderId",
//        entityColumn = "foodId",
//        associateBy = Junction(FoodOrder::class)
//    )
//    val orders:List<Order>
//        )