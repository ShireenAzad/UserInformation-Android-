package com.example.userinfo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.userinfo.databinding.ActivityMainBinding


class MainActivity() : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var visibleFieldsCheck: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
         val userName = binding.userNameET.text.toString().trim()
        val email = binding.emailET.text.toString().trim()
        val phoneNumber = binding.phoneNumberET.text.toString().trim()
        val pinCode = binding.pinCodeET.text.toString().trim()
        val address = binding.addressET.text.toString().trim()
        binding.validate.setOnClickListener {
            if (fieldsValidationToCheckAllFieldsAreEntered(userName,email,phoneNumber,pinCode,address) && emailValidation(email) && phoneNumberValidation(phoneNumber) && pinCodeValidation(pinCode)) {
                binding.validUserName.setText(userName)
                binding.validEmail.setText(email)
                binding.validPhoneNumber.setText(phoneNumber)
                binding.validPinCode.setText(pinCode)
                binding.validAddress.setText(address)
                visibleFieldsCheck = true
                fieldsDisplayOnValidate(visibleFieldsCheck)
                binding.confirm.setOnClickListener {

                    dataPassingFromActivityToActivityOnConfirm()
                }
                binding.cancel.setOnClickListener {
                    visibleFieldsCheck = false
                    fieldsDisplayOnValidate(visibleFieldsCheck)
                }

            }


        }
    }

   fun fieldsValidationToCheckAllFieldsAreEntered(userName:String,email: String,phone: String,pinCode: String,address:String): Boolean {
        if ((userName.isEmpty()) || (email.isEmpty()) || (phone.isEmpty()) || (pinCode.isEmpty()) || (address.isEmpty())) {
            Toast.makeText(this, "Every field is mandatory", Toast.LENGTH_LONG).show()
            return false

        } else {
            return true
        }
    }

     fun phoneNumberValidation(phone:String): Boolean {
        if (phone.length == 10) {
            return true
        } else {
            Toast.makeText(this, "Phone number ( should be only length of 10) ", Toast.LENGTH_LONG)
                .show()
            return false
        }
    }

     fun pinCodeValidation(pinCode:String): Boolean {
        if (pinCode.length == 6) {
            return true
        } else {
            Toast.makeText(this, "Pin code ( should be only length of 6) ", Toast.LENGTH_LONG)
                .show()
            return false
        }
    }

    fun emailValidation(email: String): Boolean {
        if ((email.contains("@")) && ((email.endsWith(".com")) || (email.endsWith("co.in")))
        ) {
            return true
        } else {
            Toast.makeText(this, " Email should have @ and .com or co.in", Toast.LENGTH_LONG).show()
            return false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(USERNAME, binding.validUserName.text.toString())
        outState.putString(EMAIL, binding.validEmail.text.toString())
        outState.putString(PHONENUMBER, binding.validPhoneNumber.text.toString())
        outState.putString(PINCODE, binding.validPinCode.text.toString())
        outState.putString(ADDRESS, binding.validAddress.text.toString())
        outState.putBoolean(VISIBLE, visibleFieldsCheck)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        if (savedInstanceState.getBoolean(VISIBLE)) {
            binding.validUserName.setText(savedInstanceState.getString(USERNAME))
            binding.validEmail.setText(savedInstanceState.getString(EMAIL))
            binding.validPhoneNumber.setText(savedInstanceState.getString(PHONENUMBER))
            binding.validPinCode.setText(savedInstanceState.getString(PINCODE))
            binding.validAddress.setText(savedInstanceState.getString(ADDRESS))
            fieldsDisplayOnValidate(savedInstanceState.getBoolean(VISIBLE))
            visibleFieldsCheck = true
            binding.confirm.setOnClickListener {
                dataPassingFromActivityToActivityOnConfirm()
            }
            binding.cancel.setOnClickListener {
                fieldsDisplayOnValidate(false)
                visibleFieldsCheck = false
            }

        }
        super.onRestoreInstanceState(savedInstanceState)

    }

    private fun fieldsDisplayOnValidate(visible: Boolean) {
        binding.validUserName.isVisible = visible
        binding.validEmail.isVisible = visible
        binding.validPhoneNumber.isVisible = visible
        binding.validPinCode.isVisible = visible
        binding.validAddress.isVisible = visible
        binding.confirm.isVisible = visible
        binding.cancel.isVisible = visible
        binding.userNameET.isVisible = !visible
        binding.emailET.isVisible = !visible
        binding.phoneNumberET.isVisible = !visible
        binding.pinCodeET.isVisible = !visible
        binding.addressET.isVisible = !visible
        binding.validate.isVisible = !visible

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