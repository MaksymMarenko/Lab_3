package com.example.catimages.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.catimages.infrastructure.MyRepository
import com.example.catimages.R

class CatViewModel: Fragment() {

    private val repository = MyRepository()
    private val viewModel = MyViewModel(repository)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val descriptionButton = view.findViewById<Button>(R.id.descriptionButton)
        val updateButton = view.findViewById<Button>(R.id.updateButton)

        descriptionButton.setOnClickListener {
            findNavController().navigate(R.id.action_catFragment_to_infoFragment)
        }

        viewModel.catImage.observe(viewLifecycleOwner, Observer { cat ->
            Glide.with(this).load(cat?.url).into(imageView)
        })

        updateButton.setOnClickListener{
            viewModel.updateCatImage() // Assuming you have a function in your ViewModel to update the image
        }
    }

}
