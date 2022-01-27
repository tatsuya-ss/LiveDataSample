package com.example.livedatasample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
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

class NumberViewModel: ViewModel() {
    private var currentNumber = 0

    val number: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun didTapCountUpButton() {
        currentNumber += 1
        number.value = currentNumber
    }

}