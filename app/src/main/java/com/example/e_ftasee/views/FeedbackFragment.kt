package com.example.e_ftasee.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.e_ftasee.R

class FeedbackFragment: Fragment() {

    private lateinit var communicator: ConnectorFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        communicator = activity as ConnectorFragment
        val  feedback_fragment : View = inflater!!.inflate(R.layout.feedback_layout, container, false)

        val feedback1 =  feedback_fragment?.findViewById<View>(R.id.editTextTextPersonName3) as EditText
        val feedback2 =  feedback_fragment?.findViewById<View>(R.id.editTextTextPersonName2) as EditText
        val feedback = "Feedback for staff: "+feedback1.text.toString()+" Feedback for experience/food: "+feedback2.text.toString()
        val button =  feedback_fragment?.findViewById<View>(R.id.button5) as Button
        button.setOnClickListener{
            communicator.feedback(feedback)
        }
        return feedback_fragment
    }

}