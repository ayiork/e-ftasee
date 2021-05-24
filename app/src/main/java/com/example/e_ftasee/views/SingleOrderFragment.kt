package com.example.e_ftasee.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.e_ftasee.R
import com.example.e_ftasee.models.Food
import com.example.e_ftasee.models.Order
import com.example.e_ftasee.viewmodels.FoodViewModel
import com.example.e_ftasee.viewmodels.MainViewModel
import com.example.e_ftasee.viewmodels.OrdersViewModel

class SingleOrderFragment: Fragment(),View.OnClickListener  {

    private val orderViewModel: OrdersViewModel by activityViewModels()
    private val mainViewModel: MainViewModel by activityViewModels()
    private var mCurrentPosition = -1
    private lateinit var order: TextView
    private lateinit var vieww: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        // Inflate the layout for this fragment
        // Log.i("FoodFragmentStart", "onCreateview");

        vieww = inflater.inflate(R.layout.order_layout, container, false) as View
        order = vieww.findViewById(R.id.ordertext) as TextView
        val addToOrderBut: Button = vieww!!.findViewById(R.id.place_order_button) as Button
        addToOrderBut.setOnClickListener(this)
        return vieww
    }

    @Override
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        orderViewModel.getSelectedFood().observe(viewLifecycleOwner, {
//            Log.i("SingleOrderFragment", "onViewCreated");
//            order.text = it.second.details +"\n\n"  + "\nprice: €"+ it.second.totalPrice
//            mCurrentPosition = it.first
//        })
        var table:Int=0
        mainViewModel.givenID().observeForever(){id->table=id}
        Log.i("SingleOrderFragment", table.toString());
        var ord: Order? = orderViewModel.getMyOrder(table)
        if (ord !=null)
            order.text = ord!!.details +"\n\n" + "price: €" + ord!!.totalPrice
    }

    @Override
    override fun onClick(v: View?) {

//        lateinit var f: Food
        var table:Int=0
        mainViewModel.givenID().observe(this){id->table=id}
        orderViewModel.placeOrder(table)
        Log.i("placeOrder","ordedr placed")

        Toast.makeText(activity,"Order placed", Toast.LENGTH_SHORT).show()

    }

    @Override
    override fun onDestroyView(){
        super.onDestroyView()
        mainViewModel.givenID().removeObservers(this)
    }
}