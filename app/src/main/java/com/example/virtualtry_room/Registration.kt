package com.example.virtualtry_room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.kotlin.readyplayerme.R
import com.kotlin.readyplayerme.databinding.ActivityRegistrationBinding

class Registration : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    lateinit var auth: FirebaseAuth

    var databaseReference: DatabaseReference?=null
    var database: FirebaseDatabase?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth=FirebaseAuth.getInstance()
        database=FirebaseDatabase.getInstance()
        databaseReference=database?.reference!!.child("profile")

        register()
    }

    private fun register() {
        binding.RegisterBTN.setOnClickListener {
            if (TextUtils.isEmpty(R.id.et_fname.toString())) {
                binding.etFname.error = "Please Enter First Name"
                return@setOnClickListener

            } else if (TextUtils.isEmpty(R.id.et_LName.toString())) {
                binding.etLName.error = "Please Enter Last Name"
                return@setOnClickListener

            } else if (TextUtils.isEmpty(R.id.et_regemail.toString())) {
                binding.etRegemail.error = "Please Enter Email"
                return@setOnClickListener

            } else if (TextUtils.isEmpty(R.id.et_contact.toString())) {
                binding.etContact.error = "Please Enter Contact"
                return@setOnClickListener

            } else if (TextUtils.isEmpty(R.id.et_password1.toString())) {
                binding.etPassword1.error = "Please Enter Password"
                return@setOnClickListener

            } else if (TextUtils.isEmpty(R.id.et_passwordCon.toString())) {
                binding.etPasswordCon.error = "Please Confirm Password"
                return@setOnClickListener

            }
            val FirstName=binding.etFname.text.toString()
            val LastName=binding.etLName.text.toString()
            val Email=binding.etRegemail.text.toString()
            val Contact= binding.etContact.text.toString()
            val Password= binding.etPassword1.text.toString()

            val Users=User(FirstName,LastName, Email,Contact)
            databaseReference?.push()?.setValue(Users)
            auth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener {
                if (it.isSuccessful) {
                    val currentUser = auth.currentUser
                    val currentUserDB=databaseReference?.child((currentUser?.uid!!))
                    currentUserDB?.child("firstname")?.setValue(R.id.et_fname.toString())
                    currentUserDB?.child("lastname")?.setValue(R.id.et_LName.toString())

                    currentUserDB?.child("contact")?.setValue(R.id.et_contact.toString())

                    Toast.makeText(this@Registration,"Welcome to Dress Up Droid", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this,Landing::class.java))


                }else{
                    Toast.makeText(this@Registration,"Registration failed!! Please try again!", Toast.LENGTH_LONG).show()

                }
            }
        }
        binding.HaveACc.setOnClickListener{
            startActivity(Intent(this@Registration,Login::class.java))
        }

    }
}