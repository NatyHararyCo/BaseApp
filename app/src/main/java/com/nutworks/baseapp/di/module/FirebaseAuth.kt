package com.nutworks.baseapp.di.module

interface FirebaseAuth {
    fun getInstance() : com.google.firebase.auth.FirebaseAuth
}

class FirebaseAuthImpl : FirebaseAuth{
    override fun getInstance() = com.google.firebase.auth.FirebaseAuth.getInstance()


}