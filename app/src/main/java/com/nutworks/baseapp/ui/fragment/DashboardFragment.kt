package com.nutworks.baseapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.nutworks.baseapp.R
import kotlinx.android.synthetic.main.dashboard_fragment.*
import org.koin.android.ext.android.inject

class DashboardFragment : BaseFragment() {
    private val firebaseAuth : com.nutworks.baseapp.di.module.FirebaseAuth by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.dashboard_fragment, container, false)
        return inflater.inflate(R.layout.dashboard_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()

        val currentUser = firebaseAuth.getInstance().currentUser

        currentUser.let {
            Glide.with(this).load(it?.photoUrl).into(userImage)
            userName.text = it?.displayName
            userEmail.text = it?.email
        }



    }
}