package com.bca.tj.loginwithsocialsites

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        buttonRegister.setOnClickListener {
          if(TextUtils.isEmpty(etEmail.text))
              editTextEmail.error = "Empty Email!!!"

        }
    }
}
