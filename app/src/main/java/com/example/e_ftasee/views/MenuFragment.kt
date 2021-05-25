package com.example.e_ftasee.views

import com.example.e_ftasee.viewmodels.FoodViewModel
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.*
import com.example.e_ftasee.R

class MenuFragment: ListFragment() {

    private val foodViewModel: FoodViewModel by activityViewModels()
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // We need to use a different list item layout for devices older than Honeycomb
        val layout = android.R.layout.simple_list_item_activated_1
        // Create an array adapter for the list view, using the Ipsum headlines array
        listAdapter = ArrayAdapter(requireActivity(), layout, foodViewModel.getFoodNames())

    }
    @Override
    override fun onStart() {
        super.onStart()
        if (parentFragmentManager.findFragmentById(R.id.food_details_fragment) != null) {
            listView.choiceMode = ListView.CHOICE_MODE_SINGLE
            Log.i("MenuFragmentStart", parentFragmentManager.findFragmentById(R.id.food_details_fragment).toString())
        }

    }
    @Override
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        foodViewModel.selectFoodAt(position)
        listView.setItemChecked(position, true)
        val userFrag = parentFragmentManager.findFragmentById(R.id.food_details_fragment) as FoodFragment?
                if (userFrag == null) {
                    val transaction = parentFragmentManager.beginTransaction()
                    val newFragment = FoodFragment()
                    transaction.replace(R.id.fragment_container, newFragment).addToBackStack(null)
                    transaction.commit()
                }
    }

    @Override
    override fun onStop() {
        super.onStop()
        listView.setItemChecked(0, false)
    }

}
