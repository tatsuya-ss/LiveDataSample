package com.example.livedatasample

class CountUp() {

    private var currentNumber = 0

    fun countUp(): Int {
        currentNumber += 1
        return currentNumber
    }

}