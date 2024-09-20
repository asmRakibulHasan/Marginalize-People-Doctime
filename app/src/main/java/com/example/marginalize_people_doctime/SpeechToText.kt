package com.example.marginalize_people_doctime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marginalize_people_doctime.databinding.FragmentLogInBinding
import com.example.marginalize_people_doctime.databinding.FragmentSpeechToTextBinding

class SpeechToText : Fragment() {

    private lateinit var binding: FragmentSpeechToTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentSpeechToTextBinding.inflate(inflater, container, false)
        return binding.root
    }




}