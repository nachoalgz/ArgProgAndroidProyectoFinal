package com.example.argproyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.argproyectofinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.resultado.observe(this) {
            println("Los datos ingresados: $it")
            binding.TextViewResult.text = "${it.dataString}"
        }

        binding.cmpBtn.setOnClickListener {
            val str1: String = binding.EditText1.text.toString()
            val str2: String = binding.EditText2.text.toString()
            mainViewModel.compareStr(str1, str2)
        }
    }
}