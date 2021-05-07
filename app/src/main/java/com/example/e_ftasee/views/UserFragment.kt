package com.example.e_ftasee.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.e_ftasee.R

class UserFragment: Fragment() {

    private lateinit var user_fragment: ConstraintLayout


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val  user_fragment : View = inflater!!.inflate(R.layout.user_layout, container, false)

        val imageButton2 =  user_fragment?.findViewById<View>(R.id.imageButton2) as ImageButton
        imageButton2.setOnClickListener{
            Toast.makeText(activity,"A waiter/waitress is called. If you want to cancel the calling, press again the button.", Toast.LENGTH_SHORT).show()
        }

        val imageButton3 =  user_fragment?.findViewById<View>(R.id.imageButton3) as ImageButton
        imageButton3.setOnClickListener{
            Toast.makeText(activity,"Your bill is coming! If you want to cancel the calling, press again the button.", Toast.LENGTH_SHORT).show()
        }

        val imageButton4 =  user_fragment?.findViewById<View>(R.id.imageButton4) as ImageButton
        imageButton4.setOnClickListener{
            Toast.makeText(activity,"Image 4", Toast.LENGTH_SHORT).show()
        }

        val imageButton5 =  user_fragment?.findViewById<View>(R.id.imageButton5) as ImageButton
        imageButton5.setOnClickListener{
            Toast.makeText(activity,"Image 5", Toast.LENGTH_SHORT).show()
        }
        return user_fragment
    }

}