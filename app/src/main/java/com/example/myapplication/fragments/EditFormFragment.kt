package com.example.myapplication.fragments

import android.os.Bundle
import android.os.Parcelable
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.SharedViewModel
import com.example.myapplication.User
import com.example.myapplication.Validations
import com.example.myapplication.databinding.FragmentEditFormBinding


class EditFormFragment : Fragment(R.layout.fragment_edit_form) {
    private var editFormBinding: FragmentEditFormBinding? = null
    private var viewModel: SharedViewModel? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        val binding = FragmentEditFormBinding.inflate(inflater, container, false)
        editFormBinding = binding

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        editFormBinding?.validate?.setOnClickListener {
           val userName=editFormBinding?.userNameET?.text.toString()
            val email=editFormBinding?.emailET?.text.toString()
            val phone=editFormBinding?.phoneNumberET?.text.toString()
            val pinCode=editFormBinding?.pinCodeET?.text.toString()
            val address=editFormBinding?.addressET?.text.toString()
                viewModel?.setUserName(userName)
                viewModel?.setEmail(email)
                viewModel?.setPhoneNumber(phone)
                viewModel?.setPinCode(pinCode)
                viewModel?.setAddress(address)
            println("pinCode at Binding"+pinCode)
            if (validatingForm(userName, email, phone, pinCode, address)) {
                val confirmDetailsFragment = ConfirmDetailsFragment()
                val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
                fragmentTransaction?.replace(R.id.fragment_container, confirmDetailsFragment)
                fragmentTransaction?.addToBackStack(null)
                fragmentTransaction?.commit()

            }
        }
        val bundle = this.arguments
        if (bundle!=null){
            val user = bundle.getParcelable<Parcelable>("user") as User
            editFormBinding?.userNameET?.text= Editable.Factory.getInstance().newEditable(user.userName)
            editFormBinding?.emailET?.text=Editable.Factory.getInstance().newEditable(user.email)
            editFormBinding?.phoneNumberET?.text=Editable.Factory.getInstance().newEditable(user.phoneNumber)
            editFormBinding?.pinCodeET?.text=Editable.Factory.getInstance().newEditable(user.pinCode)
            editFormBinding?.addressET?.text=Editable.Factory.getInstance().newEditable(user.address)
        }

    }
    private fun validatingForm(userName: String, email: String, phone: String, pinCode: String, address: String): Boolean {
        val validations = Validations()
        val fieldsValidationToCheckAllFieldsAreEntered = validations.fieldsValidationToCheckAllFieldsAreEntered( requireContext(),userName, email, phone, pinCode, address)
        val emailValidation = validations.emailValidation( requireContext(),email)
        val phoneNumberValidation = validations.phoneNumberValidation(requireContext(), phone)
        println("pinCode at Validation"+pinCode)
        val pinCodeValidation = validations.pinCodeValidation( requireContext(),pinCode)
        val validationResult = fieldsValidationToCheckAllFieldsAreEntered && emailValidation && phoneNumberValidation && pinCodeValidation
        return validationResult

    }

}

