package com.chaeniiz.githubapipractice.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.chaeniiz.githubapipractice.R
import com.chaeniiz.githubapipractice.Stargazer
import com.chaeniiz.githubapipractice.StargazerAdapter

class StargazerNameViewHolder(itemView: View, var itemClick: StargazerAdapter.StargazerClickListener) : RecyclerView.ViewHolder(itemView) {
    var textName: TextView = itemView.findViewById(R.id.tvName)

    fun bind(stargazerList: ArrayList<Stargazer>?, position: Int) {
        textName.text = stargazerList!!.get(position).name
        itemView.setOnClickListener {
            itemClick.getItem(adapterPosition)
        }
    }
}
