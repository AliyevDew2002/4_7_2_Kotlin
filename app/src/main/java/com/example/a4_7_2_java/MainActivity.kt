package com.example.a4_7_2_java

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a4_7_2_java.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
  lateinit var binding:ActivityMainBinding
        lateinit var textInputEmail: TextInputLayout
        lateinit var textInputPassword:TextInputLayout
        lateinit var textInputUsername:TextInputLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        var view=binding.root
        setContentView(view)

        textInputEmail=binding.textInputEmail
        textInputPassword=binding.textInputPassword
        textInputUsername=binding.textInputUsername

    }


    private fun validateEmail(): Boolean {
        val emailInput: String = textInputEmail.getEditText()?.getText().toString().trim()
         if (emailInput.isEmpty()) {
            textInputEmail.setError("Bu Oyna Bo'sh!"); return false

        } else {

            textInputEmail.setError(null); return true

        }
    }

    private fun validateUsername(): Boolean {
        val usernameInput: String = textInputUsername.getEditText()?.getText().toString().trim()
         if (usernameInput.isEmpty()) {
            textInputUsername.setError("Bu oyna bo'sh!")
             return false
        } else if (usernameInput.length < 15) {
            textInputUsername.setError("Minimal 15ta harf bo'lishi kerak!")
             return false
        } else {
            textInputUsername.setError(null)
             return true
        }
    }

    private fun validatePassword(): Boolean {
        val paswordInput: String = textInputPassword.getEditText()?.getText().toString().trim()
         if (paswordInput.isEmpty()) {
            textInputPassword.setError("Bu Oyna Bo'sh!")
             return false
        } else {
            textInputPassword.setError(null)
             return true
        }
    }

    fun confirmInput(v: View?) {
        if (!validateEmail() or !validatePassword() or !validateUsername()) {
            return
        }
        var input = "Email: " + textInputEmail.getEditText()?.getText().toString()
        input += "\n"
        input += "Username: " + textInputUsername.getEditText()?.getText().toString()
        input += "\n"
        input += "Password: " + textInputPassword.getEditText()?.getText().toString()
        input += "\n"
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show()
    }
}