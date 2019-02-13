package com.bca.tj.loginwithsocialsites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        btnNewPassword.setOnClickListener {
            if (TextUtils.isEmpty(edEmail.text.toString()))
                return@setOnClickListener
            else FirebaseAuth.getInstance().sendPasswordResetEmail(edEmail.text.toString()).addOnCompleteListener {
                if (it.isComplete)
                    Toast.makeText(applicationContext, "Reset link send", Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(applicationContext, "Mail sending error", Toast.LENGTH_LONG).show()

            }

        }
    }
}
