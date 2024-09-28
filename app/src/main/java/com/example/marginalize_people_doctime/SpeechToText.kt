package com.example.marginalize_people_doctime

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.marginalize_people_doctime.databinding.FragmentSpeechToTextBinding
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.util.Objects


class SpeechToText : Fragment() {

    private lateinit var binding: FragmentSpeechToTextBinding
    private val REQUEST_CODE_SPEECH_INPUT = 1
    var prompt = "Write a story about a magic backpack."

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.mic.setOnClickListener{
            if(isInternetAvailable(requireActivity())){
                micClicked()
            }else{
                Toast.makeText(requireActivity(), "Please Check Internet Connection.", Toast.LENGTH_LONG).show()
            }
        }

        binding.resutText.movementMethod = ScrollingMovementMethod()

        binding.sendBtn.setOnClickListener{

            val searchText = binding.editText.text

            if(!isInternetAvailable(requireActivity())){
                Toast.makeText(requireActivity(), "Please Check Internet Connection.", Toast.LENGTH_LONG).show()
            }else if(searchText.isEmpty()){
                Toast.makeText(requireActivity(), "Empty Search text.", Toast.LENGTH_LONG).show()
            }else{
                prompt = searchText.toString()
                modelCall()
            }
        }

    }

    private fun micClicked() {
        // on below line we are calling speech recognizer intent.
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)

        // on below line we are passing language model
        // and model free form in our intent
        intent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )

        // on below line we are passing our
        // language as a default language.
        intent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE,
            "bn"
        )

        // on below line we are specifying a prompt
        // message as speak to text on below line.
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak to text")

        // on below line we are specifying a try catch block.
        // in this block we are calling a start activity
        // for result method and passing our result code.
        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT)
        } catch (e: Exception) {
            // on below line we are displaying error message in toast
            Toast
                .makeText(
                    requireActivity(), " " + e.message,
                    Toast.LENGTH_SHORT
                )
                .show()
        }
    }

    // on below line we are calling on activity result method.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // in this method we are checking request
        // code with our result code.
        if (requestCode == REQUEST_CODE_SPEECH_INPUT) {
            // on below line we are checking if result code is ok
            if (resultCode == RESULT_OK && data != null) {

                // in that case we are extracting the
                // data from our array list
                val res: ArrayList<String> =
                    data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<String>

                // on below line we are setting data
                // to our output text view.
                prompt = Objects.requireNonNull(res)[0]
                modelCall()
            }
        }
    }

    private fun modelCall() {
        val generativeModel =
            GenerativeModel(
                // Specify a Gemini model appropriate for your use case
                modelName = "gemini-1.5-flash",
                // Access your API key as a Build Configuration variable (see "Set up your API key" above)
                apiKey = "AIzaSyAhz_5xClV6TefQNZH2qWMy8RTKGAg1hqs"
            )

        MainScope().launch {
            val response = generativeModel.generateContent(prompt)
            binding.resutText.text = response.text
        }
    }


}