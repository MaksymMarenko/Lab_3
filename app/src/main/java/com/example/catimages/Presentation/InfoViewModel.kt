package com.example.catimages.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.catimages.R

class InfoViewModel : Fragment() {

    private lateinit var nameTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var infoTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)
        nameTextView = view.findViewById(R.id.nameTextView)
        descriptionTextView = view.findViewById(R.id.descriptionTextView)
        infoTextView = view.findViewById(R.id.infoTextView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            nameTextView.text = generateRandomAnimalName()
            descriptionTextView.text = generateRandomAnimalDescription()
            infoTextView.text = generateRandomPhotoInfo()
    }

    private fun generateRandomAnimalName(): String {
        val animalNames = listOf("Maine Coon", "Persian", "Siamese", "Bengal", "Sphynx", "Ragdoll")
        return animalNames.random()
    }

    private fun generateRandomAnimalDescription(): String {
        val animalDescriptions = listOf(
            "A large and friendly breed",
            "Known for its luxurious coat",
            "Elegant and vocal",
            "Wild and exotic appearance",
            "Hairless and affectionate",
            "Docile and easygoing"
        )
        return animalDescriptions.random()
    }


    private fun generateRandomPhotoInfo(): String {
        val fileSize = (1..10).random()
        val width = (100..1000).random()
        val height = (100..1000).random()
        return "Size: $fileSize MB, Width: $width pixels, Height: $height pixels"
    }
}
