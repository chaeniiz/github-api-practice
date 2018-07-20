package com.chaeniiz.githubapipractice

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class StargazerAdapter(var stargazerList: ArrayList<Stargazer>?, var itemClick: StargazerClickListener) : RecyclerView.Adapter<StargazerAdapter.StargazerViewHolder>() {
    override fun getItemCount(): Int {
        return stargazerList!!.size
    }

    interface StargazerClickListener {
        fun getItem(position: Int)
    }

    override fun onBindViewHolder(holder: StargazerViewHolder, position: Int) {
        holder.bindData(stargazerList, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StargazerViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_stargazer, parent, false)
        return StargazerViewHolder(view, itemClick)
    }

    class StargazerViewHolder(itemView: View, var itemClick: StargazerClickListener) : RecyclerView.ViewHolder(itemView) {
        var textName: TextView = itemView.findViewById(R.id.tvName)
        fun bindData(stargazerList: ArrayList<Stargazer>?, position: Int) {
            textName.text = stargazerList!!.get(position).name
            itemView.setOnClickListener {
                itemClick.getItem(adapterPosition)
            }
        }
    }
}
