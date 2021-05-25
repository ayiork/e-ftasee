package com.example.e_ftasee.views

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.e_ftasee.FoodApplication
import com.example.e_ftasee.R
import com.example.e_ftasee.viewmodels.MainViewModel
import com.example.e_ftasee.viewmodels.MessageViewModel
import com.example.e_ftasee.viewmodels.OrdersViewModel
import com.example.e_ftasee.viewmodels.TcpServerService

class MainActivity : AppCompatActivity(), ConnectorFragment{

    lateinit var context: Context
    private val mainViewModel: MainViewModel by viewModels()
    private val ordersViewModel: OrdersViewModel by viewModels()
    private val messageViewModel: MessageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ordersViewModel.repository = (application as FoodApplication).repository
        messageViewModel.repositoryMsg = (application as FoodApplication).repositoryMsg
        if (findViewById<View>(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return
            }
            val firstFragment = TableFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, firstFragment).commit()
        }
    }

    //Server Service, accepts clients and save messages to smartphone's db
    private fun startServerService() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(Intent(applicationContext, TcpServerService::class.java))
        } else {
            startService(Intent(applicationContext, TcpServerService::class.java))
        }
    }

    //if the code is correct, then show the user fragment (includes all features)
    override fun passCode(code: Int) {
        if (mainViewModel.tableCode(code)){
            val transaction = supportFragmentManager.beginTransaction()
            val newFragment = UserFragment()
            transaction.replace(R.id.fragment_container, newFragment).addToBackStack(null)
            transaction.commit()
        }
        else
            Toast.makeText(this,this.getString(R.string.wrongCode), Toast.LENGTH_SHORT).show()
    }

    //based on user's choice do the appropriate action
    override fun tableChoice(choice: Int) {
        //Send a message to the server that this table want a waiter
        if (choice==1) {
            var id: Int? = mainViewModel.givenID().value
            if (id != null) {
                mainViewModel.sendMessage(id,this.getString(R.string.clientWaiter))
            }
        }
        //Send a message to the server that this table want the bill
        else if (choice==2){
            var id: Int? = mainViewModel.givenID().value
            if (id != null) {
                mainViewModel.sendMessage(id,this.getString(R.string.clientBill))
            }
        }
        //Show the menu
        else if(choice==3){
            val transaction = supportFragmentManager.beginTransaction()
            val newFragment = MenuFragment()
            transaction.replace(R.id.fragment_container, newFragment).addToBackStack(null)
            transaction.commit()
        }
        //Show user's order
        if(choice == 4){
            val transaction = supportFragmentManager.beginTransaction()
            val newFragment = SingleOrderFragment()
            transaction.replace(R.id.fragment_container, newFragment).addToBackStack(null)
            transaction.commit()
        }
        //Show feedback fragment, so the user will be able to give a feedback
        else if(choice==5){
            val transaction = supportFragmentManager.beginTransaction()
            val newFragment = FeedbackFragment()
            transaction.replace(R.id.fragment_container, newFragment).addToBackStack(null)
            transaction.commit()
        }
    }

    //show the login Fragment
    override fun loginPage() {
        val transaction = supportFragmentManager.beginTransaction()
        val newFragment = LogInFragment()
        transaction.replace(R.id.fragment_container, newFragment).addToBackStack(null)
        transaction.commit()
    }

    //if the login is successful, starts the server service and show the message fragment
    override fun login(user: String, pass: String) {
        if (mainViewModel.auth(user,pass)){
            startServerService()
            val transaction = supportFragmentManager.beginTransaction()
            val newFragment = MessageFragment()
            transaction.replace(R.id.fragment_container, newFragment).addToBackStack(null)
            transaction.commit()
        }
        else
            Toast.makeText(this,this.getString(R.string.invalid), Toast.LENGTH_SHORT).show()
    }

    //send the feedback to the server
    override fun feedback(feedback: String){
        var id: Int? = mainViewModel.givenID().value
        if (id != null) {
            mainViewModel.sendMessage(id,feedback)
        }
        popFragment()
    }

    //pop the current fragment
    override fun popFragment() {
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.popBackStack()
    }

    //the service must end when the application is destroyed
    override fun onDestroy() {
        super.onDestroy()
        applicationContext.stopService(Intent(this, TcpServerService::class.java))
    }
}