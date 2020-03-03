package com.nutworks.baseapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.nutworks.baseapp.R
import com.nutworks.baseapp.api.response.Result

var personList : ArrayList<Result?> = ArrayList()

class HomeAdapter : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(personList[position]!!) //TODO add a smarter nullcheck
    }

    fun setData(result: ArrayList<Result?>){
        personList.addAll(result)
        notifyDataSetChanged()
    }
}

class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private var tvName : TextView = itemView.findViewById(R.id.tvName)
    private var tvBirthYear : TextView = itemView.findViewById(R.id.tvBirthYear)
    private var tvGender : TextView = itemView.findViewById(R.id.tvGender)
    private var card : MaterialCardView = itemView.findViewById(R.id.card)

    private var name : String? = null
    private var birthYear : String? = null
    private var gender : String? = null

    init{
        setListeners()
    }

    private fun setListeners(){
        card.setOnLongClickListener{
            card.isChecked = !card.isChecked
            true
        }
    }

    fun bind(result: Result) {
        name = result.name
        birthYear = result.birth_year
        gender = result.gender

        tvName.text = name
        tvBirthYear.text = birthYear
        tvGender.text = gender
    }
}