package com.nutworks.baseapp.ui.activity

import android.content.Intent
import android.os.Bundle
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseUser
import com.nutworks.baseapp.R
import com.nutworks.baseapp.di.module.appModule
import kotlinx.android.synthetic.main.login_activity.*
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LoginActivity : BaseActivity() {

    private lateinit var authProviders: ArrayList<AuthUI.IdpConfig>
    private var currentUser: FirebaseUser? = null

    private val firebaseAuth : com.nutworks.baseapp.di.module.FirebaseAuth by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@LoginActivity)
            modules(appModule)
        }

        initFirebaseAuth()
        setListeners()
    }

    override fun onStart() {
        super.onStart()

        // Get data on current user
        currentUser = firebaseAuth.getInstance().currentUser
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Open the MainActivity, when login is complete TODO make sure there is a check on successful login according to codes
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initFirebaseAuth() {
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
                    .setTheme(R.style.AppTheme)
                    .setLogo(R.drawable.ic_launcher_foreground)
                    .setAvailableProviders(authProviders)
                    .build(), 200
            )
        }

        btnSignOut.setOnClickListener {
            firebaseAuth.getInstance().signOut()
        }
    }
}