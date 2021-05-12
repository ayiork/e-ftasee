package com.example.e_ftasee.views

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_ftasee.R
import com.example.e_ftasee.models.Food

class CustomAdapterMenu : RecyclerView.Adapter<CustomAdapterMenu.ViewHolder>(){
   
    // late int must be changed
    // models.FoodModel must be created
    private lateinit var food: ArrayList<Food>



    fun setFood(FoodList: ArrayList<Food>) {
        food = FoodList
        notifyDataSetChanged()
    }
    @Override
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.food_layout, parent, false)
        val tv = v.findViewById<TextView>(R.id.foodtext)
        return ViewHolder(v, tv)
    }

    @Override
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = String.format("Setting textview for position: %s", position)
        Log.i("CustomAdapterMenu", message)
        holder.textView.text = food.get(position).name
    }
    @Override
    override fun getItemCount(): Int {
        Log.i("CustomAdapterMenu", String.format("Getting item count: %s", food.size))
        return food.size
    }
    class ViewHolder(frameLayout: View?, // each data item is just a string in this case
                     val textView: TextView) : RecyclerView.ViewHolder(frameLayout!!)

    // when you press on food to call the appropriate functions
    interface ViewHolderListener {

    }
}