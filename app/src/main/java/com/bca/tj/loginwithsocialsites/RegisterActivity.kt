package com.bca.tj.loginwithsocialsites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    //private lateinit var fireBaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initUI()
        buttonRegister.setOnClickListener {
            validateEmailAndPassword()
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
        when{
            p0.isNullOrBlank() -> {}
        }

        if (!(p0.isNullOrBlank()))
            etPasswordLayout.isErrorEnabled = false
        else {
            etPasswordLayout.isErrorEnabled = true
            etPasswordLayout.error = "Empty Password!!!"
        }
    }


}
