package com.example.assessmentrecyclerviewget

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) { // Prevent adding fragment multiple times on config changes
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, UserListFragment()).commit()
        }
    }
}