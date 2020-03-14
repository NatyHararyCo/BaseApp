package com.nutworks.baseapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nutworks.baseapp.R
import com.nutworks.baseapp.adapter.HomeAdapter
import com.nutworks.baseapp.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : BaseFragment() {

    private lateinit var adapter : HomeAdapter
    private lateinit var viewModel : HomeViewModel
    private var pageCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        setAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.home_fragment, container, false)

        addMorePersons(pageCount)

        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter


    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel = viewModelProvider.create(HomeViewModel::class.java)
    }

    private fun setAdapter(){
        adapter = HomeAdapter()
    }

    private fun setListeners(){
        buttonAddMore.setOnClickListener{
            pageCount += 1
            addMorePersons(pageCount)
        }

        buttonGetNext.setOnClickListener{
            pageCount += 1
            replaceWithNewPersonsData(pageCount)
        }
    }

    private fun addMorePersons(page : Int){
        viewModel.getPersonsFromRepo(page).observe(viewLifecycleOwner, Observer {
                result -> adapter.setData(result, false)})
    }

    private fun replaceWithNewPersonsData(page : Int){
        viewModel.getPersonsFromRepo(page).observe(viewLifecycleOwner, Observer {
                result -> adapter.setData(result, true)})
    }
}