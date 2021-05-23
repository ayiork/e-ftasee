package com.example.e_ftasee.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.e_ftasee.R
import com.example.e_ftasee.viewmodels.FoodViewModel
import com.example.e_ftasee.viewmodels.OrdersViewModel

class SingleOrderFragment: Fragment() {

    private val orderViewModel: OrdersViewModel by activityViewModels()
    private var mCurrentPosition = -1
    private lateinit var order: TextView
    private lateinit var vieww: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        // Inflate the layout for this fragment
        // Log.i("FoodFragmentStart", "onCreateview");

        vieww = inflater.inflate(R.layout.order_layout, container, false) as View
        order = vieww.findViewById(R.id.ordertext) as TextView

        return vieww
    }

    @Override
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        orderViewModel.getSelectedFood().observe(viewLifecycleOwner, {
            Log.i("SingleOrderFragment", "onViewCreated");
            order.text = it.second.details +"\n\n"  + "\nprice: €"+ it.second.totalPrice
            mCurrentPosition = it.first
        })
    }
}