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
import com.example.marginalize_people_doctime.viewModels.UserViewModel


class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLogInBinding
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
        binding =  FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("NullCheck", "Login ${userViewModel.name} ${userViewModel.age} ${userViewModel.mobile} ${userViewModel.password}")

        binding.buttonLogin.setOnClickListener{
//            val mobile  = binding.editTextMobileNo.text.toString()
//            val password  = binding.editTextPassword.text.toString()
//
//            if(mobile.isEmpty() || password.isEmpty() ){
//                showNullNotification()
//                return@setOnClickListener
//            }else if(mobile != userViewModel.mobile || password != userViewModel.password){
//                showWrongPassNotification()
//                return@setOnClickListener
//            }

            findNavController().navigate(R.id.navigateToLanding)
        }
        binding.btnSignUp.setOnClickListener{
            findNavController().navigate(R.id.navigateToSignUpScreen)
        }
    }

    fun showNullNotification(){
        Toast.makeText(requireActivity(), "প্রতি ক্ষেত্র সম্পূর্ণ পূরণ করুন.", Toast.LENGTH_LONG).show()
    }

    fun showWrongPassNotification(){
        Toast.makeText(requireActivity(), "ভুল মোবাইল নম্বর বা পাসওয়ার্ড.", Toast.LENGTH_LONG).show()
    }



}