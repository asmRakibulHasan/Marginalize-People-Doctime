package com.example.marginalize_people_doctime

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.marginalize_people_doctime.databinding.FragmentLogInBinding
import com.example.marginalize_people_doctime.databinding.FragmentSignupBinding
import com.example.marginalize_people_doctime.viewModels.UserViewModel


class SignUp : Fragment() {

    private lateinit var binding: FragmentSignupBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel = ViewModelProvider(requireActivity())[UserViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSignUp.setOnClickListener{
            val name  = binding.editTextUserName.text.toString()
            val age  = binding.editTextAge.text.toString()
            val mobile  = binding.editTextMobileNo.text.toString()
            val password  = binding.editTextPassword.text.toString()

            Log.d("NullCheck", "SignUp $name $age $mobile $password")

            if(name.isEmpty() || age.isEmpty() || mobile.isEmpty() || password.isEmpty() ){
                showNullNotification()
                return@setOnClickListener
            }

            userViewModel.name = name
            userViewModel.age = age
            userViewModel.mobile = mobile
            userViewModel.password = password

            Toast.makeText(requireActivity(), "নিবন্ধন সফলভাবে সম্পন্ন হয়েছে.", Toast.LENGTH_LONG).show()
            findNavController().navigateUp()
        }

    }

    fun showNullNotification(){
        Toast.makeText(requireActivity(), "প্রতি ক্ষেত্র সম্পূর্ণ পূরণ করুন.", Toast.LENGTH_LONG).show()
    }

}