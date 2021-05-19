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
       // Log.i("FoodFragmentStart", "onCreateview");

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

