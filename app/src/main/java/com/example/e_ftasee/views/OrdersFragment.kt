package com.example.e_ftasee.views

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.annotation.Nullable
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import com.example.e_ftasee.R
import com.example.e_ftasee.models.Order
import com.example.e_ftasee.viewmodels.OrdersViewModel



class OrdersFragment: ListFragment() {

    private lateinit var communicator: ConnectorFragment
    private val ordersViewModel: OrdersViewModel by activityViewModels()
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // We need to use a different list item layout for devices older than Honeycomb
        val layout = android.R.layout.simple_list_item_activated_1
        // Create an array adapter for the list view, using the Ipsum headlines array
        ordersViewModel.init()

        ordersViewModel.getOrdersList().observe(this, object : Observer<List<Order?>?> {
            @Override
            override fun onChanged(@Nullable orders: List<Order?>?) {
                var names: MutableList<String> = ArrayList()
                for (order in orders!!)
                    names.add("Table Number: " + order!!.tableNum)
                Log.i("SingleOrderFragment", "onViewCreated")
                listAdapter = ArrayAdapter(requireActivity(), layout,names)

            }
        })
       // listAdapter = ArrayAdapter(requireActivity(), layout, ordersViewModel.getOrdersNames())

    //Log.i("MenuFragmentCreate", foodViewModel.getFoodNames().toString())
    }
    @Override
    override fun onStart() {
        super.onStart()

        // When in two-pane layout, set the listview to highlight the selected list item
        // (We do this during onStart because at the point the listview is available.)
        if (parentFragmentManager.findFragmentById(R.id.food_details_fragment) != null) {
            listView.choiceMode = ListView.CHOICE_MODE_SINGLE
            //Log.i("MenuFragmentStart", parentFragmentManager.findFragmentById(R.id.food_details_fragment).toString())
        }

    }
    @Override
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        // Notify the parent activity of selected item
        //mCallback?.onArticleSelected(position)

        // Set the item as checked to be highlighted when in two-pane layout
        ordersViewModel.getOrdersList().observe(this, object : Observer<List<Order?>?> {
            @Override
            override fun onChanged(@Nullable orders: List<Order?>?) {
                // Update the cached copy of the words in the adapter.
                ordersViewModel.selectOrderAt(position,orders?.get(position)!!)
            }
        })
        //ordersViewModel.selectOrderAt(position)
        listView.setItemChecked(position, true)
        val userFrag = parentFragmentManager.findFragmentById(R.id.food_details_fragment) as AdminOrderFragment?
                if (userFrag == null) {
                    val transaction = parentFragmentManager.beginTransaction()
                    val newFragment = AdminOrderFragment()
                    transaction.replace(R.id.fragment_container, newFragment).addToBackStack(null)
                    transaction.commit()
                }
        //listView.setItemChecked(position, true)
    }

    @Override
    override fun onStop() {
        super.onStop()
        listView.setItemChecked(0, false)
    }

    @Override
    override fun onDestroyView() {
        super.onDestroyView()
    }
    @Override
    override fun onDestroy() {
        super.onDestroy()
    }
}
