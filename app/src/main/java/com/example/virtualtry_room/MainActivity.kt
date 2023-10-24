package com.example.virtualtry_room

import android.bluetooth.BluetoothHealthAppConfiguration
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.ui.AppBarConfiguration
import com.example.virtualtry_room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var handler: Handler
    lateinit var binding: ActivityMainBinding



    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)
        handler = Handler()
        handler.postDelayed(
            {
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish()

            }, 1500
        )
    }
}