package com.example.e_ftasee.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.e_ftasee.R


class TableFragment : Fragment(){

    private lateinit var communicator: ConnectorFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val  tableLayout: View = inflater!!.inflate(R.layout.table_layout, container, false)
        communicator = activity as ConnectorFragment

        //actions for submit button
        val submitButton =  tableLayout?.findViewById<View>(R.id.button) as Button
        submitButton.setOnClickListener{
            val codeText = tableLayout?.findViewById<View>(R.id.editTextNumberDecimal) as EditText
            if (!codeText.text.isNullOrEmpty()){
                val code= codeText.text.toString().toInt()
                communicator.passCode(code)
            }
        }

        //actions for admin button
        val adminButton =  tableLayout?.findViewById<View>(R.id.button3) as Button
        adminButton.setOnClickListener{
            communicator.loginPage()
        }

        return tableLayout
    }

}