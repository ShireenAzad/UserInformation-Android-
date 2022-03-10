package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.*
import com.example.myapplication.databinding.FragmentConfirmDetailsBinding
import java.util.EnumSet.of

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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn=view.findViewById<View>(R.id.confirm) as Button
        val txt=view.findViewById<View>(R.id.validUserName) as TextView

        val model= ViewModelProvider.of(requireActivity()).get(Communicator::class.java)

        model.message.observe(this, object : Observer<Any> {
            override fun onChanged(o: Any?) {
                txt.text = o!!.toString()
            }
        })
        btn.setOnClickListener { view ->
            //write some code here
        }
    }
}