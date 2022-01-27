package com.example.livedatasample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumberViewModel: ViewModel() {

    private val countUp = CountUp()

    val number: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun didTapCountUpButton() {
        number.value = countUp.countUp()
    }

}

class CountUp() {
    private var currentNumber = 0

    fun countUp(): Int {
        currentNumber += 1
        return currentNumber
    }
    
}