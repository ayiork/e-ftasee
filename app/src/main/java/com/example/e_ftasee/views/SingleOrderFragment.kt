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
import com.example.e_ftasee.models.Order
import com.example.e_ftasee.viewmodels.MainViewModel
import com.example.e_ftasee.viewmodels.OrdersViewModel

class SingleOrderFragment: Fragment(),View.OnClickListener  {

    private val orderViewModel: OrdersViewModel by activityViewModels()
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var order: TextView
    private lateinit var vieww: View
    private lateinit var communicator: ConnectorFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        vieww = inflater.inflate(R.layout.order_layout, container, false) as View
        communicator = activity as ConnectorFragment
        order = vieww.findViewById(R.id.ordertext) as TextView
        val addToOrderBut: Button = vieww!!.findViewById(R.id.place_order_button) as Button
        addToOrderBut.setOnClickListener(this)
        addToOrderBut.visibility=View.GONE
        val deleteOrderBut: Button = vieww!!.findViewById(R.id.delete_order_button) as Button
        deleteOrderBut.setOnClickListener(this)
        deleteOrderBut.visibility=View.GONE
        return vieww
    }

    @Override
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var table = 0
        mainViewModel.givenID().observeForever(){id->table=id}
        var ord: Order? = orderViewModel.getMyOrder(table)
        if (ord !=null) {
            val addToOrderBut: Button = vieww!!.findViewById(R.id.place_order_button) as Button
            addToOrderBut.visibility=View.VISIBLE
            val deleteOrderBut: Button = vieww!!.findViewById(R.id.delete_order_button) as Button
            deleteOrderBut.visibility=View.VISIBLE
            order.text = ord!!.details + "\n\n" + "price: €" + ord!!.totalPrice
        }
    }

    @Override
    override fun onClick(v: View?) {
        // if the place order button is clicked then the order is send to the viewmodel to be
        // inserted into the db
        if (v!!.id==R.id.place_order_button) {
            var table: Int = 0
            mainViewModel.givenID().observe(this) { id -> table = id }
            if (table != 0) {
                orderViewModel.placeOrder(table)
                Toast.makeText(activity, R.string.order_placed, Toast.LENGTH_SHORT).show()
                communicator.popFragment()
            }
        }
        // if the delete order button is clicked then the appropriate function of viewmodel is
        // called to delete the order from the repository
        else if(v!!.id==R.id.delete_order_button){
            var table: Int = 0
            mainViewModel.givenID().observe(this) { id -> table = id }
            if (table != 0) {
                orderViewModel.deleteOrder(table)
                Toast.makeText(activity, R.string.order_cleared, Toast.LENGTH_SHORT).show()
                communicator.popFragment()
            }
        }
    }

    @Override
    override fun onDestroyView(){
        super.onDestroyView()
        mainViewModel.givenID().removeObservers(this)
    }
}