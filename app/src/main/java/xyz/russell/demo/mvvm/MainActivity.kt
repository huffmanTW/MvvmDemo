package xyz.russell.demo.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import xyz.russell.demo.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        binding.btnAdd.setOnClickListener {
            viewModel.incrementByOne()
        }

        binding.btnMinus.setOnClickListener {
            viewModel.minusByOne()
        }

        viewModel.countLiveData.observe(this) {
            binding.tvCountView.text = it.toString()
        }

    }
}