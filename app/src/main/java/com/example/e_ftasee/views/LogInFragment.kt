package com.example.e_ftasee.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.e_ftasee.R

class LogInFragment: Fragment() {

    private lateinit var communicator: ConnectorFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val loginLayout: View = inflater!!.inflate(R.layout.login_layout, container, false)
        communicator = activity as ConnectorFragment

        val button =  loginLayout?.findViewById<View>(R.id.button4) as Button
        button.setOnClickListener{
            val username = loginLayout?.findViewById<View>(R.id.editTextTextPersonName) as EditText
            val password = loginLayout?.findViewById<View>(R.id.editTextTextPassword) as EditText
            if (!username.text.isNullOrEmpty() && !username.text.isNullOrEmpty()){
                val user= username.text.toString()
                val pass= password.text.toString()
                communicator.login(user,pass)
            }
        }

        return loginLayout
    }
}