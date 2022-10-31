package com.example.mvcsampleapp01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity(), Observer, View.OnClickListener {

    // creating object of Model class
    var myModel: Model? = null

    // creating object of Button class
    var Button1: Button? = null
    var Button2: Button? = null
    var Button3: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // creating relationship between the
        // observable Model and the
        // observer Activity
        myModel = Model()
        myModel!!.addObserver(this)

        // assigning button IDs to the objects
        Button1 = findViewById(R.id.button1)
        Button2 = findViewById(R.id.button2)
        Button3 = findViewById(R.id.button3)

        // transfer the control to Onclick() method
        // when a button is clicked by passing
        // argument "this"
        Button1?.setOnClickListener(this)
        Button2?.setOnClickListener(this)
        Button3?.setOnClickListener(this)
    }

    // function to update the view after
    // the values are modified by the model
    override fun update(p0: Observable?, p1: Any?) {
        // changing text of the buttons
        // according to updated values
        Button1!!.text = "Count: " + myModel!!.getValueAtIndex(0)
        Button2!!.text = "Count: " + myModel!!.getValueAtIndex(1)
        Button3!!.text = "Count: " + myModel!!.getValueAtIndex(2)

    }


    // calling setValueAtIndex() method
    // by passing appropriate arguments
    // for different buttons
    override fun onClick(p0: View) {
        when(p0.id){
            R.id.button1 -> myModel?.setValueAtIndex(0)
            R.id.button2 -> myModel?.setValueAtIndex(1)
            R.id.button3 -> myModel?.setValueAtIndex(2)

        }
    }
}