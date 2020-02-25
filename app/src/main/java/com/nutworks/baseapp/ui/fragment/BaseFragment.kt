package com.nutworks.baseapp.ui.fragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

open class BaseFragment : Fragment() {
    lateinit var viewModelProvider: ViewModelProvider.AndroidViewModelFactory

    // Creates the ViewModelFactory. Override this and create your own ViewModel
    @Override
    open fun initViewModel(){
        viewModelProvider = ViewModelProvider.AndroidViewModelFactory.getInstance(activity?.application!!)
    }
}