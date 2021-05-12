package com.example.e_ftasee.views

import android.os.Bundle
import android.os.Trace.isEnabled
import android.system.Os.remove
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.fragment.app.activityViewModels
import com.example.e_ftasee.R
import com.example.e_ftasee.viewmodels.FoodViewModel





class FoodFragment: Fragment(),View.OnClickListener {

    private val foodViewModel: FoodViewModel by activityViewModels()
    private var mCurrentPosition = -1
    private lateinit var food: TextView
    private lateinit var vieww: View
    @Override
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        // Inflate the layout for this fragment
        Log.i("FoodFragmentStart", "onCreateview");
//        val food_frag = inflater.inflate(R.layout.food_fragment, container, false)
//        food = food_frag.findViewById(R.id.foodtext) as TextView
       // food = inflater.inflate(R.layout.food_textview, container, false) as TextView

        vieww = inflater.inflate(R.layout.food_layout, container, false) as View
        food = vieww.findViewById(R.id.foodtext) as TextView
        val addToOrderBut: Button = vieww!!.findViewById(R.id.add_button) as Button
        addToOrderBut.setOnClickListener(this)
        return vieww
    }

    @Override
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foodViewModel.getSelectedFood().observe(viewLifecycleOwner, {
            Log.i("FoodFragmentStart", "onViewCreated");
            food.text = it.second.details
            mCurrentPosition = it.first
        })
    }
    @Override
    override fun onClick(v: View?) {

        Toast.makeText(activity,"Added to order", Toast.LENGTH_SHORT).show()
    }


}



// recycler view will be added here
//class FoodFragment: ListFragment() {
//
//    private val foodViewModel: FoodViewModel by activityViewModels()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // We need to use a different list item layout for devices older than Honeycomb
//        val layout = android.R.layout.simple_list_item_activated_1
//
//        // Create an array adapter for the list view, using the Ipsum headlines array
//        listAdapter = ArrayAdapter(requireContext(), layout, foodViewModel.getFoodNames())
//    }
//
//    override fun onStart() {
//        super.onStart()
//
//        // When in two-pane layout, set the listview to highlight the selected list item
//        // (We do this during onStart because at the point the listview is available.)
//        if (parentFragmentManager.findFragmentById(R.id.food_details_fragment) != null) {
//            listView.choiceMode = ListView.CHOICE_MODE_SINGLE
//        }
//    }
//    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
//        // Notify the parent activity of selected item
//        //mCallback?.onArticleSelected(position)
//
//        // Set the item as checked to be highlighted when in two-pane layout
//        foodViewModel.selectFoodAt(position)
//        listView.setItemChecked(position, true)
//        //listView.setItemChecked(position, true)
//    }
//}