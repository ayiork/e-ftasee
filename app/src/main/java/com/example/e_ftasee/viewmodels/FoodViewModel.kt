package com.example.e_ftasee.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_ftasee.models.Food
import com.example.e_ftasee.models.FoodManager
import java.util.*
import kotlin.collections.ArrayList

class FoodViewModel: ViewModel() {

    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodNames: Array<String?>
    private var selectedFood = MutableLiveData<Pair<Int, Food>>()
    private val foodManager = FoodManager()

    init{
        loadFood()
        loadFoodNames()
    }

    // here can be added another int to show the amount of food
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

    private fun loadFoodNames(){
        foodNames = foodManager.getFoodNames()
    }

    private fun loadFood(){
        foodList= foodManager.food
    }
}