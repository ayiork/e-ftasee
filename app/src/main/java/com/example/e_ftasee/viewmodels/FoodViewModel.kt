package com.example.e_ftasee.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_ftasee.models.Food
import com.example.e_ftasee.repository.FoodRepository
import kotlin.collections.ArrayList

class FoodViewModel: ViewModel() {

    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodNames: Array<String?>
    private var selectedFood = MutableLiveData<Pair<Int, Food>>()
    private val foodManager = FoodRepository()

    init{
        loadFood()
        loadFoodNames()
    }

    fun getSelectedFood(): LiveData<Pair<Int, Food>> {
        return selectedFood
    }

    fun selectFoodAt(position: Int) {
        Log.i("selectfood", selectedFood.value.toString());
        selectedFood.value = Pair(position, foodList[position])
    }

    fun getFoodNames(): Array<String?>{
        return foodNames
    }

    fun getFoodById(id: Long):Food?{
        for (food in foodList)
            if (food.foodId== id)
                return food
        return null
    }

    private fun loadFoodNames(){
        foodNames = foodManager.getFoodNames()
    }

    private fun loadFood(){
        foodList= foodManager.food
    }
}