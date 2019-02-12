package com.bca.tj.loginwithsocialsites

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private var mContext: Context = this
    private var mGoogleApiClient: GoogleApiClient? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        configureSignIn()
        btnSignOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback {
                val intent = Intent(this@HomeActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun configureSignIn() {
        // Configure sign-in to request the user's basic profile like name and email
        val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        // Build a GoogleApiClient with access to GoogleSignIn.API and the options above.
        mGoogleApiClient = GoogleApiClient.Builder(mContext)
                .addApi(Auth.GOOGLE_SIGN_IN_API, options)
                .build()
        mGoogleApiClient!!.connect()
    }


}
