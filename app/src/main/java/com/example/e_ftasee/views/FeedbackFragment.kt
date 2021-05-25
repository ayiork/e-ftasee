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
        val button =  feedback_fragment?.findViewById<View>(R.id.button5) as Button
        button.setOnClickListener{
            var text1=""
            if (!feedback1.text.isNullOrEmpty())
                text1= feedback1.text.toString()
            var text2=""
            if (!feedback2.text.isNullOrEmpty())
                text2= feedback2.text.toString()
            val feedback = this.getString(R.string.feedbackStaff)+" "+text1+this.getString(R.string.feedbackFood)+" "+text2
            communicator.feedback(feedback)
        }
        return feedback_fragment
    }

}