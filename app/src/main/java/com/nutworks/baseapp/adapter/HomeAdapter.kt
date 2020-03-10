package com.nutworks.baseapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.nutworks.baseapp.R
import com.nutworks.baseapp.api.response.Result
import com.nutworks.baseapp.databinding.HomeItemBinding
import com.nutworks.baseapp.model.PersonModel

var personList : ArrayList<PersonModel?> = ArrayList()

class HomeAdapter : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding : HomeItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.home_item, parent, false)
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(personList[position]!!) //TODO add a smarter nullcheck
    }

    fun setData(result: ArrayList<Result?>){
        result.forEach{
            personList.add(PersonModel(it?.name,it?.gender,it?.birth_year))
        }
        notifyDataSetChanged()
    }
}

class HomeViewHolder(val binding: HomeItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(data : Any){
        binding.setVariable(BR.Person, data)
        binding.executePendingBindings()
    }
}