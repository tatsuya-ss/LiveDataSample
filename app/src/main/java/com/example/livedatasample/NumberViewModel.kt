package com.example.livedatasample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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