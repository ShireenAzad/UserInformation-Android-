package com.example.userinfo


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val userName=findViewById<TextView>(R.id.userName)
        userName.setText("Hi "+intent.getStringExtra(USERNAME).toString() +", How are you? Are you staying at "+intent.getStringExtra(
            ADDRESS).toString()+intent.getStringExtra(PINCODE).toString()+". I am not able to contact you on "+intent.getStringExtra(
            PHONENUMBER).toString()+". Can I email you the details at "+intent.getStringExtra(EMAIL).toString())
    }
}