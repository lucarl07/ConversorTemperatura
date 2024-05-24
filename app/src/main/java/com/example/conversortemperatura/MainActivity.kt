package com.example.conversortemperatura

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.conversortemperatura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

       binding.btnConvert.setOnClickListener {
           if (!binding.editCelsius.text.toString().isEmpty()) {
               val celsius = binding.editCelsius.text.toString().toDouble()
               val fahrenheit = celsius * 1.8 + 32

               binding.returnCelsius.text = "$celsius ºC"
               binding.returnFahrenheit.text = "$fahrenheit ºF"
           } else {
               binding.returnCelsius.text = getString(R.string.error_empty)
               binding.returnFahrenheit.text = getString(R.string.ellipsis)
           }
       }
    }
}