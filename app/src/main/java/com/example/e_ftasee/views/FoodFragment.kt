package com.example.e_ftasee.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.e_ftasee.R
import com.example.e_ftasee.models.Food
import com.example.e_ftasee.viewmodels.FoodViewModel
import com.example.e_ftasee.viewmodels.MainViewModel
import com.example.e_ftasee.viewmodels.OrdersViewModel


class FoodFragment: Fragment(),View.OnClickListener {

    private val ordersViewModel: OrdersViewModel by activityViewModels()
    private val foodViewModel: FoodViewModel by activityViewModels()
    private val mainViewModel: MainViewModel by activityViewModels()
    private var mCurrentPosition = -1
    private lateinit var food: TextView
    private lateinit var vieww: View

    @Override
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
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
            food.text = it.second.name +"\n\n" + it.second.details + "\nprice: €"+ it.second.price
            mCurrentPosition = it.first
        })
    }


    @Override
    override fun onClick(v: View?) {
        // add the selected food into the order of the table
        lateinit var f:Food
        foodViewModel.getSelectedFood().observe(viewLifecycleOwner, {
            f=it.second
        })
        var table = 0
        mainViewModel.givenID().observe(this){id->table=id}
        ordersViewModel.insert(f,table)
        Log.i("templist",f.toString())
        Toast.makeText(activity,this.getString(R.string.added), Toast.LENGTH_SHORT).show()
    }


}

