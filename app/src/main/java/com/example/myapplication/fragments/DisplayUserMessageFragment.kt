package com.example.myapplication.fragments

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.User
import com.example.myapplication.databinding.FragmentDisplayUserMessageBinding


class DisplayUserMessageFragment : Fragment() {
    private lateinit var displayUserMessageBinding: FragmentDisplayUserMessageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDisplayUserMessageBinding.inflate(inflater, container, false)
        displayUserMessageBinding= binding

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bundle = this.arguments
        if (bundle != null) {
            val user = bundle.getParcelable<Parcelable>("user") as User
            displayUserMessageBinding.userDetails.text = getString(
                R.string.userData,
                user.userName,
                user.address,
                user.pinCode,
                user.phoneNumber,
                user.email
            )

        }
        super.onViewCreated(view, savedInstanceState)
    }
}