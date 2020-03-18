package com.nutworks.baseapp.di.module

interface FirebaseAuth {
    fun giveHello(): String
    fun getInstance() : com.google.firebase.auth.FirebaseAuth
}

class FirebaseAuthImpl : FirebaseAuth{
    override fun giveHello() = "Hello Firebase"
    override fun getInstance() = com.google.firebase.auth.FirebaseAuth.getInstance()


}