package com.example.e_ftasee.repository

import android.util.Log
import com.example.e_ftasee.models.Food

class FoodManager {
    lateinit var food: ArrayList<Food>

    init{
        addFood()
    }


    private fun addFood(){
        food = ArrayList()

        food.add(
            Food(name="Mix", details = "Cyprus pitta with 2 skewers pork and 1 skewer sheftalia",price = 5.0)
        )

        food.add(
            Food(name="Souvlakia", details = "Cyprus pitta with 3 skewers pork ",price = 6.0)
        )
        food.add(
            Food(name= "Halloumi", details="Cyprus pitta with halloumi",price = 4.0)
        )

        food.add(
            Food(name="Chicken Souvlaki",details="Cyprus pitta with 3 skewers chicken",price = 5.5)
        )
        food.add(
            Food(name="Desert-rizogalo", details="Rizogalo with cinnamon",price = 7.0)
        )

        food.add(
            Food(name="Sausages",details = "Cyprus pitta with 3 sausages",price = 5.0)
        )
        food.add(
            Food(name="Mix", details = "Cyprus pitta with 2 skewers pork and 1 skewer sheftalia",price = 5.0)
        )

        food.add(
            Food(name="Souvlakia", details = "Cyprus pitta with 3 skewers pork ",price = 6.0)
        )
        food.add(
            Food(name= "Halloumi", details="Cyprus pitta with halloumi",price = 4.0)
        )

        food.add(
            Food(name="Chicken Souvlaki",details="Cyprus pitta with 3 skewers chicken",price = 5.5)
        )
        food.add(
            Food(name="Desert-rizogalo", details="Rizogalo with cinnamon",price = 7.0)
        )

        food.add(
            Food(name="Sausages",details = "Cyprus pitta with 3 sausages",price = 5.0)
        )
        food.add(
            Food(name="Mix", details = "Cyprus pitta with 2 skewers pork and 1 skewer sheftalia",price = 5.0)
        )

        food.add(
            Food(name="Souvlakia", details = "Cyprus pitta with 3 skewers pork ",price = 6.0)
        )
        food.add(
            Food(name= "Halloumi", details="Cyprus pitta with halloumi",price = 4.0)
        )

        food.add(
            Food(name="Chicken Souvlaki",details="Cyprus pitta with 3 skewers chicken",price = 5.5)
        )
        food.add(
            Food(name="Desert-rizogalo", details="Rizogalo with cinnamon",price = 7.0)
        )

        food.add(
            Food(name="Sausages",details = "Cyprus pitta with 3 sausages",price = 5.0)
        )


        //Log.i("FoodManager", "food added")
    }

    fun getFoodNames(): Array<String?> {
        val names = arrayOfNulls<String>(food.size)

        food.forEachIndexed { i, foodd ->
            names[i] = foodd.name
        }
        return names
    }

}