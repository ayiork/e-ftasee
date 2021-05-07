package com.example.e_ftasee.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import com.example.e_ftasee.viewmodels.MainViewModel
import com.example.e_ftasee.R

class MainActivity : AppCompatActivity(), ConnectorFragment{

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (findViewById<View>(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return
            }
            val firstFragment = TableFragment()
            //firstFragment.arguments = intent.extras
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, firstFragment).commit()
        }
    }

    override fun passCode(editTextInput: Int) {
        if (mainViewModel.tableCode(editTextInput)){
            val transaction = supportFragmentManager.beginTransaction()
            val newFragment = UserFragment()
            transaction.replace(R.id.fragment_container, newFragment).addToBackStack(null)
            transaction.commit()
        }
        else
            Toast.makeText(this,"Wrong code, please give the correct one!", Toast.LENGTH_SHORT).show()
    }

}