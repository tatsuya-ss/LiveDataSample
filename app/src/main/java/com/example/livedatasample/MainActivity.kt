package com.example.livedatasample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.livedatasample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val numberViewModel = NumberViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupLiveData()
        setupButton()

    }

    private fun setupButton() {
        binding.countUpButton.setOnClickListener {
            numberViewModel.didTapCountUpButton()
        }
    }

    private fun setupLiveData() {
        val nameObserver = Observer<Int> { newName ->
            binding.numberText.text = newName.toString()
        }
        numberViewModel.number.observe(this, nameObserver)
    }

    private fun  setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}