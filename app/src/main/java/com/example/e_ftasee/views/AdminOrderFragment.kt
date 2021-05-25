package com.example.e_ftasee.views

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.e_ftasee.R
import com.example.e_ftasee.viewmodels.MainViewModel
import com.example.e_ftasee.viewmodels.MessageViewModel
import com.example.e_ftasee.viewmodels.OrdersViewModel

class AdminOrderFragment: Fragment(),View.OnClickListener  {

    private val orderViewModel: OrdersViewModel by activityViewModels()
    private val messageViewModel: MessageViewModel by activityViewModels()
    private val mainViewModel: MainViewModel by activityViewModels()
    private var mCurrentPosition = -1
    private lateinit var order: TextView
    private lateinit var vieww: View
    private lateinit var communicator: ConnectorFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        communicator = activity as ConnectorFragment
        vieww = inflater.inflate(R.layout.order_layout, container, false) as View
        order = vieww.findViewById(R.id.ordertext) as TextView
        val addToOrderBut: Button = vieww!!.findViewById(R.id.place_order_button) as Button
        addToOrderBut.setOnClickListener(this)
        addToOrderBut.setText(R.string.removeMessage)
        addToOrderBut.visibility=View.VISIBLE
        return vieww
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Override
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        messageViewModel.getSelectedMessage().observe(viewLifecycleOwner, {
            Log.i("SingleOrderFragment", "onViewCreated");
            order.text = it.second.details +"\n\n"
            mCurrentPosition = it.first
        })


    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Override
    override fun onClick(v: View?) {
        messageViewModel.getSelectedMessage().observe(viewLifecycleOwner, {
            if (it.second!=null)
                messageViewModel.removeMessage(it.second.messageId!!)
        })
        Toast.makeText(activity,"Message removed", Toast.LENGTH_SHORT).show()
        communicator.popFragment()
    }

}