package com.example.marginalize_people_doctime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.marginalize_people_doctime.databinding.FragmentDetailsKnowBinding
import com.example.marginalize_people_doctime.databinding.FragmentHomeBinding


class DetailsKnow : Fragment() {
    private lateinit var binding: FragmentDetailsKnowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentDetailsKnowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.doctor1.setOnClickListener{
            findNavController().navigate(R.id.navigateDetailsToDoctorDetails)
        }

        binding.doctor2.setOnClickListener{
            findNavController().navigate(R.id.navigateDetailsToDoctorDetails)
        }

        binding.doctor3.setOnClickListener{
            findNavController().navigate(R.id.navigateDetailsToDoctorDetails)
        }

    }

}