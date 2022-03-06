package com.example.userinfo

import android.content.Context
import android.widget.Toast


class Validations {
    fun fieldsValidationToCheckAllFieldsAreEntered(
        mContext: Context?,
        userName: String,
        email: String,
        phone: String,
        pinCode: String,
        address: String,message: String?
    ): Boolean {
        if ((userName.isEmpty()) || (email.isEmpty()) || (phone.isEmpty()) || (pinCode.isEmpty()) || (address.isEmpty())) {
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
            return false

        } else {
            return true
        }
    }

    fun phoneNumberValidation(mContext: Context?, phone: String,message: String?): Boolean {
        if (phone.length == 10) {
            return true
        } else {
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
            return false
        }
    }

    fun pinCodeValidation(mContext: Context?, pinCode: String,message: String?): Boolean {
        if (pinCode.length == 6) {
            return true
        } else {
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
            return false
        }
    }
    fun emailValidation(mContext: Context?,email: String,message: String?): Boolean {
        if ((email.contains("@")) && ((email.endsWith(".com")) || (email.endsWith("co.in")))
        ) {
            return true
        } else {
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
            return false
        }
    }
}
