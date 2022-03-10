package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Communicator
import com.example.myapplication.R
import com.example.myapplication.SharedViewModel
import com.example.myapplication.databinding.FragmentEditFormBinding


class EditFormFragment : Fragment(R.layout.fragment_edit_form) {
    private var editFormBinding: FragmentEditFormBinding? = null
    private var viewModel: SharedViewModel? = null
    private lateinit var communicator: Communicator
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentEditFormBinding.inflate(inflater, container, false)
        editFormBinding=binding

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        editFormBinding?.validate?.setOnClickListener {
            viewModel?.setUserName(editFormBinding?.userNameET?.text.toString())
            viewModel?.setEmail(editFormBinding?.emailET?.text.toString())
            viewModel?.setPhoneNumber(editFormBinding?.phoneNumberET?.text.toString())
            viewModel?.setPinCode(editFormBinding?.pinCodeET?.text.toString())
            viewModel?.setAddress(editFormBinding?.addressET?.text.toString())
            val confirmDetailsFragment = ConfirmDetailsFragment()
            val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment_container, confirmDetailsFragment)
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()

        }

    }
}

