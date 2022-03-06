package com.example.userinfo


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val user = intent.getParcelableExtra<User>("user")
        val userName=findViewById<TextView>(R.id.userName)
        userName.setText("Hi "+user?.userName +", How are you? Are you staying at "+user?.address+user?.pinCode+". I am not able to contact you on "+user?.phoneNumber+
                ". Can I email you the details at "+user?.email)
    }
}