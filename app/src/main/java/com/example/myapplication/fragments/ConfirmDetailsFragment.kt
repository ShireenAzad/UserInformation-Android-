package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.*
import com.example.myapplication.databinding.FragmentConfirmDetailsBinding

class ConfirmDetailsFragment : Fragment(R.layout.fragment_confirm_details) {

    private lateinit var confirmDetailsBinding: FragmentConfirmDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = FragmentConfirmDetailsBinding.inflate(inflater, container, false)
        confirmDetailsBinding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        confirmDetailsBinding.validUserName
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        model.getUserName().observe(
            viewLifecycleOwner
        ) { o -> confirmDetailsBinding.validUserName.text = o!!.toString() }
        model.getEmail().observe(
            viewLifecycleOwner
        ) { o -> confirmDetailsBinding.validEmail.text = o!!.toString() }
        model.getPhoneNumber().observe(
            viewLifecycleOwner
        ) { o -> confirmDetailsBinding.validPhoneNumber.text = o!!.toString() }
        model.getPinCode().observe(
            viewLifecycleOwner
        ) { o -> confirmDetailsBinding.validPinCode.text = o!!.toString() }
        model.getAddress().observe(
            viewLifecycleOwner
        ) { o -> confirmDetailsBinding.validAddress.text = o!!.toString() }
        confirmDetailsBinding.confirm.setOnClickListener {
            view
            val displayUserMessageFragment = DisplayUserMessageFragment()
            val bundleData = bundleData(model)
            displayUserMessageFragment.arguments = bundleData
            val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment_container, displayUserMessageFragment)
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }
        confirmDetailsBinding.cancel.setOnClickListener {
            val editFormFragment = EditFormFragment()
            val bundleData = bundleData(model)
            editFormFragment.arguments = bundleData
            val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment_container, editFormFragment)
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }
    }

    fun bundleData(model: SharedViewModel): Bundle {
        val bundle = Bundle()
        val user = User(
            model.getUserName().value.toString(),
            model.getEmail().value.toString(),
            model.getPhoneNumber().value.toString(),
            model.getPinCode().value.toString(),
            model.getAddress().value.toString()
        )
        bundle.putParcelable("user", user)
        return bundle
    }

}
