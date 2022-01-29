package com.example.livedatasample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.livedatasample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val numberViewModel = NumberViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupDataBinding()

    }

    private fun setupDataBinding() {
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply {
            // これでLiveDataが正しく動く
            setLifecycleOwner(this@MainActivity)
        }
        binding.numberViewModel = this.numberViewModel
    }

}