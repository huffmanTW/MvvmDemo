package xyz.russell.demo.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        findViewById<Button>(R.id.btn_add).setOnClickListener {
            viewModel.incrementByOne()
        }

        findViewById<Button>(R.id.btn_minus).setOnClickListener {
            viewModel.minusByOne()
        }

        viewModel.countLiveData.observe(this) {
            findViewById<TextView>(R.id.tv_count_view).text = it.toString()
        }

    }
}