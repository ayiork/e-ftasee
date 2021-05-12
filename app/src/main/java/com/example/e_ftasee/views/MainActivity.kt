package com.example.e_ftasee.views

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

class MainActivity : AppCompatActivity(), ConnectorFragment{

    private val mainViewModel: MainViewModel by viewModels()
    private val foodViewModel: FoodViewModel by viewModels()

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

//        if (findViewById<View>(R.id.menu_fragment_container) != null) {
//            Log.i("MainActivity"," fragmentcontainer not null")
//            // However, if we're being restored from a previous state,
//            // then we don't need to do anything and should return or else
//            // we could end up with overlapping fragments.
//            if (savedInstanceState != null) {
//                return
//            }
//
//            // Create an instance of ExampleFragment
//            val firstFragment = MenuFragment()
//
//            // In case this activity was started with special instructions from an Intent,
//            // pass the Intent's extras to the fragment as arguments
//            firstFragment.arguments = intent.extras
//
//            // Add the fragment to the 'fragment_container' FrameLayout
//            supportFragmentManager.beginTransaction()
//                    .add(R.id.menu_fragment_container, firstFragment).commit()
//        }
//        Log.i("MainActivity"," fragmentcontainer IS null")
//        foodViewModel.getSelectedFood().observe(this, {
//// The user selected the headline of an article from the HeadlinesFragment
//
//            // Capture the article fragment from the activity layout
//            val userFrag =
//                    supportFragmentManager.findFragmentById(R.id.food_details_fragment) as FoodFragment?
//            if (userFrag == null) {
//
//                val newFragment = FoodFragment()
//                val transaction = supportFragmentManager.beginTransaction()
//                // Replace whatever is in the fragment_container view with this fragment,
//                // and add the transaction to the back stack so the user can navigate back
//                transaction.replace(R.id.menu_fragment_container, newFragment).addToBackStack(null)
//                // Commit the transaction
//                transaction.commit()
//            }
//        })
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
        if(choice==3){
            Log.i("Table choice"," is working")
            val transaction = supportFragmentManager.beginTransaction()
            val newFragment = MenuFragment()
            transaction.replace(R.id.fragment_container, newFragment).addToBackStack(null)
            transaction.commit()


//            foodViewModel.getSelectedFood().observe(this, {
//            // The user selected the headline of an article from the HeadlinesFragment
//                Log.i("Table choice"," user choosed.....")
//                // Capture the article fragment from the activity layout
//                val userFrag =
//                        supportFragmentManager.findFragmentById(R.id.food_details_fragment) as FoodFragment?
//                if (userFrag == null) {
//
//                    val newFragment = FoodFragment()
//                    val transaction = supportFragmentManager.beginTransaction()
//                    // Replace whatever is in the fragment_container view with this fragment,
//                    // and add the transaction to the back stack so the user can navigate back
//                    transaction.replace(R.id.fragment_container, newFragment).addToBackStack(null)
//                    // Commit the transaction
//                    transaction.commit()
//                }
//            })
        }
    }


}