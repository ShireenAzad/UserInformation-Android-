package com.example.userinfo


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.userinfo.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = intent.getParcelableExtra<User>("user")
        binding.userDetails.text = getString(
            R.string.userData,
            user?.userName,
            user?.email,
            user?.phoneNumber,
            user?.pinCode,
            user?.address
        )
    }
}