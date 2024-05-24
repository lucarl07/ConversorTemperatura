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
           val celsius = binding.editCelsius.text.toString().toDoubleOrNull()
           binding.returnCelsius.text = "$celsius ºC"

           if (celsius != null) {
               val fahrenheit = celsius * 1.8 + 32
               binding.returnFahrenheit.text = "$fahrenheit ºF"
           } else {
               binding.returnCelsius.text = getString(R.string.nan_error)
               binding.returnFahrenheit.text = getString(R.string.ellipsis)
           }
       }
    }
}