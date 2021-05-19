package com.example.e_ftasee.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.e_ftasee.R
import com.example.e_ftasee.viewmodels.MainViewModel


class TableFragment : Fragment(){

    //private val mainViewModel: MainViewModel by activityViewModels()
    //private lateinit var tableLayout: ConstraintLayout
    private lateinit var communicator: ConnectorFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val  tableLayout: View = inflater!!.inflate(R.layout.table_layout, container, false)
        communicator = activity as ConnectorFragment

        val button =  tableLayout?.findViewById<View>(R.id.button) as Button
        button.setOnClickListener{
            val codeText = tableLayout?.findViewById<View>(R.id.editTextNumberDecimal) as EditText
            if (!codeText.text.isNullOrEmpty()){
                val code= codeText.text.toString().toInt()
                communicator.passCode(code)
            }
        }

        val button_login =  tableLayout?.findViewById<View>(R.id.button3) as Button
        button_login.setOnClickListener{
            communicator.loginPage()
        }

        return tableLayout
    }



}