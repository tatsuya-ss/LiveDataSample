package com.example.livedatasample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.livedatasample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model = NameViewModel()
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupLiveData()
        setupButton()

    }

    private fun setupButton() {
        binding.countUpButton.setOnClickListener {
            number += 1
            model.number.value = number
        }
    }

    private fun setupLiveData() {
        val nameObserver = Observer<Int> { newName ->
            binding.numberText.text = newName.toString()
        }
        model.number.observe(this, nameObserver)
    }

    private fun  setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

class NameViewModel: ViewModel() {

    val number: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

}