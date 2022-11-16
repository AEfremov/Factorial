package ru.efremov.factorialtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import ru.efremov.factorialtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val vm by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        applyObservers()

        binding.buttonCalculate.setOnClickListener {
            vm.calculate(binding.editTextNumber.text.toString())
        }
    }

    private fun applyObservers() {
        vm.state.observe(this) {
            if (it.isInProgress) {
                binding.progressBarLoading.visibility = View.VISIBLE
                binding.buttonCalculate.isEnabled = false
            } else {
                binding.progressBarLoading.visibility = View.GONE
                binding.buttonCalculate.isEnabled = true
            }
            if (it.isError) {
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
            }
            binding.textViewFactorial.text = it.factorial
        }
    }
}