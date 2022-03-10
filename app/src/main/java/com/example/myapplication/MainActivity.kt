package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.fragments.ConfirmDetailsFragment
import com.example.myapplication.fragments.EditFormFragment

class MainActivity : AppCompatActivity(),Communicator {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val editFormFragment=EditFormFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,editFormFragment).commit()
    }


    override fun passDataCom(
        userNameET: String,
        emailET: String,
        phoneNumberET: String,
        pinCodeET: String,
        addressET: String
    ) {
        val bundle = Bundle()
        bundle.putString(USERNAME,userNameET)
        bundle.putString(EMAIL,emailET)
        bundle.putString(PHONENUMBER,phoneNumberET)
        bundle.putString(PINCODE,pinCodeET)
        bundle.putString(ADDRESS,addressET)
        val transaction = this.supportFragmentManager.beginTransaction()
        val confirmDetailsFragment= ConfirmDetailsFragment()
        confirmDetailsFragment.arguments = bundle
        transaction.replace(R.id.fragment_container, confirmDetailsFragment)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}