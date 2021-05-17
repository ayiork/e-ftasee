package com.example.e_ftasee.models

import android.util.Log

class FoodManager {
    lateinit var food: ArrayList<Food>

    init{
        addFood()
    }


    private fun addFood(){
        food = ArrayList()

        food.add(
                Food("Mix", "Cyprus pitta with 2 skewers pork and 1 skewer sheftalia\nPrice: €5.00")
        )

        food.add(
                Food("Souvlakia","Cyprus pitta with 3 skewers pork ")
        )
        food.add(
                Food("Halloumi", "Cyprus pitta with halloumi")
        )

        food.add(
                Food("Chicken Souvlaki","Cyprus pitta with 3 skewers chicken")
        )
        food.add(
                Food("Desert-rizogalo", "Rizogalo with cinnamon")
        )

        food.add(
                Food("Sausages","Cyprus pitta with 3 sausages")
        )
        food.add(
                Food("Mix", "Cyprus pitta with 2 skewers pork and 1 skewer sheftalia")
        )

        food.add(
                Food("Souvlakia","Cyprus pitta with 3 skewers pork ")
        )
        food.add(
                Food("Halloumi", "Cyprus pitta with halloumi")
        )

        food.add(
                Food("Chicken Souvlaki","Cyprus pitta with 3 skewers chicken")
        )
        food.add(
                Food("Desert-rizogalo", "Rizogalo with cinnamon")
        )

        food.add(
                Food("Sausages","Cyprus pitta with 3 sausages")
        )
        food.add(
                Food("Mix", "Cyprus pitta with 2 skewers pork and 1 skewer sheftalia")
        )

        food.add(
                Food("Souvlakia","Cyprus pitta with 3 skewers pork ")
        )
        food.add(
                Food("Halloumi", "Cyprus pitta with halloumi")
        )

        food.add(
                Food("Chicken Souvlaki","Cyprus pitta with 3 skewers chicken")
        )
        food.add(
                Food("Desert-rizogalo", "Rizogalo with cinnamon")
        )

        food.add(
                Food("Sausages","Cyprus pitta with 3 sausages")
        )
        food.add(
                Food("Mix", "Cyprus pitta with 2 skewers pork and 1 skewer sheftalia")
        )

        food.add(
                Food("Souvlakia","Cyprus pitta with 3 skewers pork ")
        )
        food.add(
                Food("Halloumi", "Cyprus pitta with halloumi")
        )

        food.add(
                Food("Chicken Souvlaki","Cyprus pitta with 3 skewers chicken")
        )
        food.add(
                Food("Desert-rizogalo", "Rizogalo with cinnamon")
        )

        food.add(
                Food("Sausages","Cyprus pitta with 3 sausages")
        )
        Log.i("FoodManager", "food added")
    }

    fun getFoodNames(): Array<String?> {
        val names = arrayOfNulls<String>(food.size)

        food.forEachIndexed { i, foodd ->
            names[i] = foodd.name
        }
        return names
    }

}