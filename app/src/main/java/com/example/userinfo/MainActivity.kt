package com.example.userinfo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        binding.editGroup.visibility = View.VISIBLE
        binding.validate.setOnClickListener {
            val userName = binding.userNameET.text.toString().trim()
            val email = binding.emailET.text.toString().trim()
            val phone = binding.phoneNumberET.text.toString().trim()
            val pinCode = binding.pinCodeET.text.toString().trim()
            val address = binding.addressET.text.toString().trim()
            binding.textGroup.visibility = View.INVISIBLE
            binding.editGroup.visibility = View.VISIBLE
            val validations = Validations()
            val fieldsValidationToCheckAllFieldsAreEntered = validations.fieldsValidationToCheckAllFieldsAreEntered(this, userName, email, phone, pinCode, address, "Every field is mandatory")
            val emailValidation = validations.emailValidation(this, email, "Email should have @ and .com or co.in")
            val phoneNumberValidation = validations.phoneNumberValidation(this, phone, "Phone number ( should be only length of 10)")
            val pinCodeValidation = validations.pinCodeValidation(this, pinCode, "Pin code ( should be only length of 6) ")
            val validationResult = fieldsValidationToCheckAllFieldsAreEntered && emailValidation && phoneNumberValidation && pinCodeValidation
            if (validationResult) {
                binding.validUserName.setText(userName)
                binding.validEmail.setText(email)
                binding.validPhoneNumber.setText(phone)
                binding.validPinCode.setText(pinCode)
                binding.validAddress.setText(address)
                binding.textGroup.visibility = View.VISIBLE
                binding.editGroup.visibility = View.INVISIBLE
                binding.confirm.setOnClickListener {

                    dataPassingFromActivityToActivityOnConfirm()
                }
                binding.cancel.setOnClickListener {
                    binding.editGroup.visibility = View.VISIBLE
                    binding.textGroup.visibility = View.INVISIBLE

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
        if (savedInstanceState.getBoolean(VISIBLE)) {

            binding.textGroup.visibility = View.INVISIBLE
            binding.editGroup.visibility = View.VISIBLE
        } else {
            binding.textGroup.visibility = View.VISIBLE
            binding.editGroup.visibility = View.INVISIBLE
            binding.validUserName.setText(savedInstanceState.getString(USERNAME))
            binding.validEmail.setText(savedInstanceState.getString(EMAIL))
            binding.validPhoneNumber.setText(savedInstanceState.getString(PHONENUMBER))
            binding.validPinCode.setText(savedInstanceState.getString(PINCODE))
            binding.validAddress.setText(savedInstanceState.getString(ADDRESS))
            binding.confirm.setOnClickListener {
                dataPassingFromActivityToActivityOnConfirm()
            }
            binding.cancel.setOnClickListener {
                binding.textGroup.visibility = View.INVISIBLE
                binding.editGroup.visibility = View.VISIBLE
            }
        }
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun dataPassingFromActivityToActivityOnConfirm() {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(USERNAME, binding.validUserName.text.toString())
        intent.putExtra(EMAIL, binding.validEmail.text.toString())
        intent.putExtra(PHONENUMBER, binding.validPhoneNumber.text.toString())
        intent.putExtra(PINCODE, binding.validPinCode.text.toString())
        intent.putExtra(ADDRESS, binding.validAddress.text.toString())
        startActivity(intent)
    }

}