package com.example.marginalize_people_doctime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.marginalize_people_doctime.databinding.FragmentLandingBinding


class LandingFragment : Fragment() {
    private lateinit var binding: FragmentLandingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLandingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonDiagnostic.setOnClickListener{
            findNavController().navigate(R.id.navigateToImageSearch)
        }

        binding.buttonVoiceSearch.setOnClickListener{
            findNavController().navigate(R.id.navigateToSpechToText)
        }

        binding.buttonHome.setOnClickListener{
            findNavController().navigate(R.id.navigateToHome)
        }

        binding.buttonOthers.setOnClickListener{
            findNavController().navigate(R.id.navigateToOthers)
        }

    }



}