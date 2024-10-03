package com.example.marginalize_people_doctime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.marginalize_people_doctime.databinding.FragmentHomeBinding
import com.example.marginalize_people_doctime.databinding.FragmentSpeechToTextBinding


class Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.doctor1.setOnClickListener{
            findNavController().navigate(R.id.navigateToDoctorDetails)
        }

        binding.doctor2.setOnClickListener{
            findNavController().navigate(R.id.navigateToDoctorDetails)
        }


        binding.doctor3.setOnClickListener{
            findNavController().navigate(R.id.navigateToDoctorDetails)
        }


    }

}