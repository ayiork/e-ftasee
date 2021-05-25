package com.example.e_ftasee.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.e_ftasee.R

class UserFragment: Fragment() {

    private lateinit var communicator: ConnectorFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        communicator = activity as ConnectorFragment
        val  user_fragment : View = inflater!!.inflate(R.layout.user_layout, container, false)

        //actions for waiter button
        val waiterButton =  user_fragment?.findViewById<View>(R.id.imageButton2) as ImageButton
        waiterButton.setOnClickListener{
            communicator.tableChoice(1)
            Toast.makeText(activity,this.getString(R.string.waiterCalled), Toast.LENGTH_SHORT).show()
        }

        //actions for bill button
        val billButton =  user_fragment?.findViewById<View>(R.id.imageButton3) as ImageButton
        billButton.setOnClickListener{
            communicator.tableChoice(2)
            Toast.makeText(activity,this.getString(R.string.billComing), Toast.LENGTH_SHORT).show()
        }
        //actions for menu button
        val menuButton =  user_fragment?.findViewById<View>(R.id.imageButton4) as ImageButton
        menuButton.setOnClickListener{
            communicator.tableChoice(3)
        }
        //actions for order button
        val orderButton =  user_fragment?.findViewById<View>(R.id.imageButton5) as ImageButton
        orderButton.setOnClickListener{
            communicator.tableChoice(4)
        }
        //actions for feedback button
        val feedbackButton =  user_fragment?.findViewById<View>(R.id.button2) as Button
        feedbackButton.setOnClickListener{
            communicator.tableChoice(5)
        }
        //rturn Fragment
        return user_fragment
    }

}