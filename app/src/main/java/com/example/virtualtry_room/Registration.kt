package com.example.virtualtry_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.virtualtry_room.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Registration : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    lateinit var auth: FirebaseAuth

    var databaseReference: DatabaseReference?=null
    var database: FirebaseDatabase?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }
}