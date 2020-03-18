package com.nutworks.baseapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nutworks.baseapp.R
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

        Log.d("NATY", firebaseAuth.getInstance().currentUser?.displayName)
    }
}