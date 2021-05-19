package com.example.e_ftasee.views

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.example.e_ftasee.viewmodels.MainViewModel
import com.example.e_ftasee.R
import com.example.e_ftasee.viewmodels.FoodViewModel
import com.example.e_ftasee.viewmodels.TcpClientService
import com.example.e_ftasee.viewmodels.TcpServerService

class MainActivity : AppCompatActivity(), ConnectorFragment{

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(Intent(applicationContext, TcpServerService::class.java))
        } else {
            startService(Intent(applicationContext, TcpServerService::class.java))
        }
        /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(Intent(applicationContext, TcpClientService::class.java))
        } else {
            startService(Intent(applicationContext, TcpClientService::class.java))
        }*/
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

    override fun tableChoice(choice: Int) {
        if (choice==1)
            mainViewModel.sendMessage("Waiter/waitress for table: "+mainViewModel.givenID().value)
        if (choice==2)
            mainViewModel.sendMessage("Bill for table: "+mainViewModel.givenID().value)
        if(choice==3){
            val transaction = supportFragmentManager.beginTransaction()
            val newFragment = MenuFragment()
            transaction.replace(R.id.fragment_container, newFragment).addToBackStack(null)
            transaction.commit()
        }
    }

    override fun loginPage() {
        val transaction = supportFragmentManager.beginTransaction()
        val newFragment = LogInFragment()
        transaction.replace(R.id.fragment_container, newFragment).addToBackStack(null)
        transaction.commit()
    }

    override fun login(user: String, pass: String) {
        if (mainViewModel.auth(user,pass)){
            val transaction = supportFragmentManager.beginTransaction()
            val newFragment = MenuFragment()
            transaction.replace(R.id.fragment_container, newFragment).addToBackStack(null)
            transaction.commit()
        }
        else
            Toast.makeText(this,"Invalid username/password, please give the correct one!", Toast.LENGTH_SHORT).show()

    }

}