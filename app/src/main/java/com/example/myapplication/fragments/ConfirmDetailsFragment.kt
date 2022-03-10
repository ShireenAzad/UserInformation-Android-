package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.*
import com.example.myapplication.databinding.FragmentConfirmDetailsBinding

class ConfirmDetailsFragment : Fragment(R.layout.fragment_confirm_details) {
private var confirmDetailsBinding:FragmentConfirmDetailsBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val binding= FragmentConfirmDetailsBinding.inflate(inflater, container, false)
        confirmDetailsBinding=binding
        binding.validUserName.text= arguments?.getString(USERNAME)
        binding.validEmail.text= arguments?.getString(EMAIL)
        binding.validPhoneNumber.text=arguments?.getString(PHONENUMBER)
        binding.validPinCode.text=arguments?.getString(PINCODE)
        binding.validAddress.text=arguments?.getString(ADDRESS)
        return binding.root
    }
    override fun onDestroyView() {
        confirmDetailsBinding = null
        super.onDestroyView()
    }
}