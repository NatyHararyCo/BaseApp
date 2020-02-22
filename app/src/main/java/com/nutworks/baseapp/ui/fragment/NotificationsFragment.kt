package com.nutworks.baseapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nutworks.baseapp.R

class NotificationsFragment : BaseFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.notification_fragment, container, false)
        return inflater.inflate(R.layout.notification_fragment, container, false)
    }
}