package com.bca.tj.loginwithsocialsites

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initUI()
        buttonRegister.setOnClickListener {
            validateEmailAndPassword()
            if (etEmail.text.toString().trim().isNotEmpty() && etPassword.text.toString().trim().isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(etEmail.text.toString().trim(), etPassword.text.toString().trim()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        startActivity(Intent(this, HomeActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(applicationContext, "E-mail or password is wrong", Toast.LENGTH_SHORT).show()
                    }

                }
            }

        }
    }

    private fun validateEmailAndPassword() {
        when {
            TextUtils.isEmpty(etEmail.text) -> {
                editTextEmail.isErrorEnabled = true
                editTextEmail.error = "Empty Email!!!"
            }
            TextUtils.isEmpty(etPassword.text) -> {
                etPasswordLayout.isErrorEnabled = true
                etPasswordLayout.error = "Empty Password!!"
            }
        }
    }

    private fun initUI() {
        etEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                isTextEmptyOrNot(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isTextEmptyOrNot(p0.toString())
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isTextEmptyOrNot(p0.toString())
            }

        })

        etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                isPasswordEmptyOrNot(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isPasswordEmptyOrNot(p0.toString())
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isPasswordEmptyOrNot(p0.toString())
            }

        })
    }


    private fun isTextEmptyOrNot(p0: String?) {
        if (!(p0.isNullOrBlank()))
            editTextEmail.isErrorEnabled = false
        else {
            editTextEmail.isErrorEnabled = true
            editTextEmail.error = "Empty Email!!!"
        }
    }

    private fun isPasswordEmptyOrNot(p0: String?) {
        when {
            p0.isNullOrBlank() -> {
            }
        }

        if (!(p0.isNullOrBlank()))
            etPasswordLayout.isErrorEnabled = false
        else {
            etPasswordLayout.isErrorEnabled = true
            etPasswordLayout.error = "Empty Password!!!"
        }
    }


}
