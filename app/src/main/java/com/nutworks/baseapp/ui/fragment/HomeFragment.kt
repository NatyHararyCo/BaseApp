package com.nutworks.baseapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.nutworks.baseapp.R
import com.nutworks.baseapp.adapter.HomeAdapter
import com.nutworks.baseapp.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : BaseFragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter : HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()

        getPersons()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.home_fragment, container, false)
        adapter = HomeAdapter()
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    private fun initViewModel(){
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
//        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.activity) TODO make this work
    }

    private fun getPersons(){
        viewModel.personsLiveData.observe(this, Observer {
                result -> adapter.setData(result)})
    }
}