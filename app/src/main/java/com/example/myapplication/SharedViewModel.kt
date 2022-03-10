package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SharedViewModel : ViewModel() {
    private val userName = MutableLiveData<String>()
    private val email = MutableLiveData<String>()
    private val phoneNumber = MutableLiveData<String>()
    private val pinCode = MutableLiveData<String>()
    private val address = MutableLiveData<String>()

    fun setUserName(userNameET: String) {
        userName.value = userNameET
    }

    fun setEmail(emailET: String) {
        email.value = emailET
    }

    fun setPhoneNumber(phoneNumberET: String) {
        phoneNumber.value = phoneNumberET
    }

    fun setPinCode(pinCodeET: String) {
        pinCode.value = pinCodeET
    }

    fun setAddress(addressET: String) {
        address.value = addressET
    }

    fun getUserName(): LiveData<String> {
        return userName
    }
    fun getEmail(): LiveData<String> {
        return email
    }
    fun getPhoneNumber(): LiveData<String> {
        return phoneNumber
    }
    fun getPinCode(): LiveData<String> {
        return pinCode
    }
    fun getAddress(): LiveData<String> {
        return address
    }

}