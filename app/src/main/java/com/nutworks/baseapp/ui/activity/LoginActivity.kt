package com.nutworks.baseapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.nutworks.baseapp.R
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : BaseActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authProviders: ArrayList<AuthUI.IdpConfig>
    private var currentUser: FirebaseUser? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        initFirebaseAuth()
        setListeners()
    }

    override fun onStart() {
        super.onStart()

        // Get data on current user
        val currentUser = firebaseAuth.currentUser
        displayUserDetailsOnToast(currentUser)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Open the MainActivity, when login is complete TODO make sure there is a check on successful login according to codes
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initFirebaseAuth() {
        firebaseAuth = FirebaseAuth.getInstance()
        authProviders = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.FacebookBuilder().build()
        )
    }

    private fun setListeners() {
        btnSignIn.setOnClickListener {
            // Create and launch sign-in intent
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(authProviders)
                    .build(), 200
            )
        }

        btnSignOut.setOnClickListener {
            firebaseAuth.signOut()
            Toast.makeText(this, "Signed out", Toast.LENGTH_LONG).show()
        }
    }

    private fun displayUserDetailsOnToast(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            val displayName = currentUser.displayName
            val uid = currentUser.uid
            val email = currentUser.email
            Toast.makeText(this, "User is $displayName, $uid, $email", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "User is null!", Toast.LENGTH_LONG).show()
        }
    }
}
