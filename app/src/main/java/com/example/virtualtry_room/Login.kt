package com.example.virtualtry_room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.kotlin.readyplayerme.R
import com.kotlin.readyplayerme.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth = FirebaseAuth.getInstance()
        login()
    }

    private fun login() {
        binding.LoginBTN.setOnClickListener {
            if (TextUtils.isEmpty(R.id.et_email.toString())) {
                Toast.makeText(
                    this,
                    "Empty Email!!",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (TextUtils.isEmpty(R.id.et_password.toString())) {
                Toast.makeText(
                    this,
                    "Empty Password!!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            val Email = binding.etEmail.text.toString()
            val Pass = binding.etPassword.text.toString()
            auth.signInWithEmailAndPassword(Email, Pass).addOnCompleteListener {
                if (it.isSuccessful) {

                    startActivity(Intent(this@Login, Landing::class.java))


                } else {
                    Toast.makeText(this@Login, "Invalid Credentials", Toast.LENGTH_LONG)
                        .show()


                }
            }
        }
        binding.DontHaveACc.setOnClickListener {
            startActivity(Intent(this@Login, Registration::class.java))
        }
    }
}