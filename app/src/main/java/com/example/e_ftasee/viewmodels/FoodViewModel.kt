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

    // return a pair that is the selected Food and its position
    fun getSelectedFood(): LiveData<Pair<Int, Food>> {
        return selectedFood
    }

    // select the food at the given position
    fun selectFoodAt(position: Int) {
        Log.i("selectfood", selectedFood.value.toString());
        selectedFood.value = Pair(position, foodList[position])
    }

    // return an array that contain the Names of the foods
    fun getFoodNames(): Array<String?>{
        return foodNames
    }

    // Given the id it returns the food that has that id
    fun getFoodById(id: Long):Food?{
        for (food in foodList)
            if (food.foodId== id)
                return food
        return null
    }

    // load the foodnames from the repository
    private fun loadFoodNames(){
        foodNames = foodManager.getFoodNames()
    }

    // load the food from the repository
    private fun loadFood(){
        foodList= foodManager.food
    }
}