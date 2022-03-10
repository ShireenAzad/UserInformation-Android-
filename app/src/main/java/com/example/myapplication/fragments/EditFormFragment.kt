package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.Communicator
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentEditFormBinding

class EditFormFragment : Fragment(R.layout.fragment_edit_form) {
    private var editFormBinding: FragmentEditFormBinding? = null
    private lateinit var communicator: Communicator
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentEditFormBinding.inflate(inflater, container, false)
        editFormBinding=binding
        communicator = requireActivity() as Communicator
        binding.validate.setOnClickListener {
            communicator.passDataCom(
                binding.userNameET.text.toString(),
                binding.emailET.text.toString(),
                binding.phoneNumberET.text.toString(),
                binding.pinCodeET.text.toString(),
                binding.addressET.text.toString()
            )
        }

        return binding.root
    }
    override fun onDestroyView() {
        editFormBinding = null
        super.onDestroyView()
    }


}

