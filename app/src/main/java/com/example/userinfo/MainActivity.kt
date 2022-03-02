package com.example.userinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.userinfo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var visibleFieldsCheck: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.validate.setOnClickListener {
            if (fieldsValidationToCheckAllFieldsAreEntered() && emailValidation() && phoneNumberValidation() && pinCodeValidation()) {
                binding.validUserName.setText(binding.userNameET.text.toString())
                binding.validEmail.setText(binding.emailET.text.toString())
                binding.validPhoneNumber.setText(binding.phoneNumberET.text.toString())
                binding.validPinCode.setText(binding.pinCodeET.text.toString())
                binding.validAddress.setText(binding.addressET.text.toString())
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

    private fun fieldsValidationToCheckAllFieldsAreEntered(): Boolean {
        if ((binding.userNameET.text.toString().trim()
                .isEmpty()) || (binding.emailET.text.toString().trim().isEmpty()) ||
            (binding.phoneNumberET.text.toString().trim().isEmpty()) || (binding.pinCodeET.text.toString()
                .trim().isEmpty()) ||
            (binding.addressET.text.toString().trim().isEmpty())
        ) {
            Toast.makeText(this, "Every field is mandatory", Toast.LENGTH_LONG).show()
            return false

        } else {
            return true
        }
    }

    private fun phoneNumberValidation(): Boolean {
        if (binding.phoneNumberET.text.toString().length == 10) {
            return true
        } else {
            Toast.makeText(this, "Phone number ( should be only length of 10) ", Toast.LENGTH_LONG)
                .show()
            return false
        }
    }

    private fun pinCodeValidation(): Boolean {
        if (binding.pinCodeET.text.toString().length == 6) {
            return true
        } else {
            Toast.makeText(this, "Pin code ( should be only length of 6) ", Toast.LENGTH_LONG)
                .show()
            return false
        }
    }

    private fun emailValidation(): Boolean {
        if ((binding.emailET.text.toString().contains("@")) && ((binding.emailET.text.toString()
                .endsWith(".com")) || (binding.emailET.text.toString().endsWith("co.in")))
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