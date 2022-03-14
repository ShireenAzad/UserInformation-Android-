package com.example.myapplication

import android.content.Context
import android.widget.Toast
import com.example.myapplication.fragments.EditFormFragment


class Validations() {
    fun fieldsValidationToCheckAllFieldsAreEntered(
        mContext: Context?,
        userName: String,
        email: String,
        phone: String,
        pinCode: String,
        address: String
    ): Boolean {
        if ((userName.isEmpty()) || (email.isEmpty()) || (phone.isEmpty()) || (pinCode.isEmpty()) || (address.isEmpty())) {
            Toast.makeText(mContext, R.string.eachFieldToast, Toast.LENGTH_SHORT).show()
            return false

        } else {
            return true
        }
    }

    fun phoneNumberValidation(mContext: Context, phone: String): Boolean {
        if (phone.length == 10) {
            return true
        } else {
            Toast.makeText(mContext, R.string.phoneNumberToast, Toast.LENGTH_SHORT).show()
            return false
        }
    }

    fun pinCodeValidation(mContext: Context, pinCode: String): Boolean {
        println(pinCode.length)
        println(pinCode)
        if (pinCode.length == 6) {
            return true
        } else {
            Toast.makeText(mContext, R.string.pinCodeToast, Toast.LENGTH_SHORT).show()
            return false
        }
    }

    fun emailValidation(mContext: Context, email: String): Boolean {
        if ((email.contains("@")) && ((email.endsWith(".com")) || (email.endsWith("co.in")))
        ) {
            return true
        } else {
            Toast.makeText(mContext, R.string.emailToast, Toast.LENGTH_SHORT).show()
            return false
        }
    }
}