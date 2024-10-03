package com.example.marginalize_people_doctime

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.marginalize_people_doctime.databinding.FragmentDoctordetailsBinding
import com.example.marginalize_people_doctime.databinding.FragmentSpeechToTextBinding


class DoctorDetails : Fragment() {

    private lateinit var binding: FragmentDoctordetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentDoctordetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.videoCall.setOnClickListener{
            val contact = "+88" // use country code with your phone number
            val url = "https://api.whatsapp.com/send?phone=$contact"
            try {
                val pm = context?.packageManager
                pm?.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
            } catch (e: PackageManager.NameNotFoundException) {
                Toast.makeText(requireActivity(), "আপনার ফোনে WhatsApp অ্যাপ ইনস্টল করা নেই", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }

        }
    }

}