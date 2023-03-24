package com.example.task_kattabozor

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.task_kattabozor.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
//    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind, R.id.container)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    window.statusBarColor = Color.BLACK
    }
}