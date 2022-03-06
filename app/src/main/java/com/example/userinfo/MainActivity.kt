package com.example.userinfo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.userinfo.databinding.ActivityMainBinding


class MainActivity() : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textGroup.visibility = View.INVISIBLE
        binding.validate.setOnClickListener {
            val userName = binding.userNameET.text.toString().trim()
            val email = binding.emailET.text.toString().trim()
            val phone = binding.phoneNumberET.text.toString().trim()
            val pinCode = binding.pinCodeET.text.toString().trim()
            val address = binding.addressET.text.toString().trim()
            binding.textGroup.visibility = View.INVISIBLE
            binding.editGroup.visibility = View.VISIBLE
            if (validatingForm(userName, email, phone, pinCode, address)) {
                binding.validUserName.setText(userName)
                binding.validEmail.setText(email)
                binding.validPhoneNumber.setText(phone)
                binding.validPinCode.setText(pinCode)
                binding.validAddress.setText(address)
                binding.textGroup.visibility = View.VISIBLE
                binding.editGroup.visibility = View.INVISIBLE
                binding.confirm.setOnClickListener {
                    dataPassingFromActivityToActivityOnConfirm(userName, email, phone, pinCode, address)
                }
                binding.cancel.setOnClickListener {
                    binding.editGroup.visibility = View.VISIBLE
                    binding.editGroup.visibility = View.INVISIBLE
                }
            }

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(USERNAME, binding.validUserName.text.toString())
        outState.putString(EMAIL, binding.validEmail.text.toString())
        outState.putString(PHONENUMBER, binding.validPhoneNumber.text.toString())
        outState.putString(PINCODE, binding.validPinCode.text.toString())
        outState.putString(ADDRESS, binding.validAddress.text.toString())
        outState.putBoolean(VISIBLE, binding.editGroup.isVisible)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        binding.validUserName.setText(savedInstanceState.getString(USERNAME))
        binding.validEmail.setText(savedInstanceState.getString(EMAIL))
        binding.validPhoneNumber.setText(savedInstanceState.getString(PHONENUMBER))
        binding.validPinCode.setText(savedInstanceState.getString(PINCODE))
        binding.validAddress.setText(savedInstanceState.getString(ADDRESS))
        visibileFields(savedInstanceState.getBoolean(VISIBLE))
        binding.confirm.setOnClickListener {
            dataPassingFromActivityToActivityOnConfirm(
                USERNAME, EMAIL, PHONENUMBER, PINCODE,
                ADDRESS
            )
        }
        binding.cancel.setOnClickListener {
            binding.editGroup.visibility = View.VISIBLE
            binding.editGroup.visibility = View.INVISIBLE
        }

        super.onRestoreInstanceState(savedInstanceState)
    }

    fun dataPassingFromActivityToActivityOnConfirm(
        userName: String,
        email: String,
        phone: String,
        pinCode: String,
        address: String
    ) {
        val intent = Intent(this, DetailsActivity::class.java)
        val user = User(userName, email, phone, pinCode, address)
        intent.putExtra("user", user)
        startActivity(intent)
    }

    fun validatingForm(userName: String, email: String, phone: String, pinCode: String, address: String): Boolean {
        val validations = Validations()
        val fieldsValidationToCheckAllFieldsAreEntered = validations.fieldsValidationToCheckAllFieldsAreEntered(this, userName, email, phone, pinCode, address, "Every field is mandatory")
        val emailValidation = validations.emailValidation(this, email, "Email should have @ and .com or co.in")
        val phoneNumberValidation = validations.phoneNumberValidation(this, phone, "Phone number ( should be only length of 10)")
        val pinCodeValidation = validations.pinCodeValidation(this, pinCode, "Pin code ( should be only length of 6) ")
        val validationResult = fieldsValidationToCheckAllFieldsAreEntered && emailValidation && phoneNumberValidation && pinCodeValidation
        return validationResult

    }

    fun visibileFields(visible: Boolean) {
        if (visible) {
            binding.textGroup.visibility = View.INVISIBLE
            binding.editGroup.visibility = View.VISIBLE
        } else {
            binding.textGroup.visibility = View.VISIBLE
            binding.editGroup.visibility = View.INVISIBLE
        }

    }

}