package com.chaeniiz.githubapipractice.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.chaeniiz.githubapipractice.R
import com.chaeniiz.githubapipractice.Stargazer
import com.chaeniiz.githubapipractice.StargazerAdapter

class StargazerDescriptionViewHolder(itemView: View, var itemClick: StargazerAdapter.StargazerClickListener) : RecyclerView.ViewHolder(itemView) {
    var textDescription: TextView = itemView.findViewById(R.id.tvDescription)

    fun bind(stargazerList: ArrayList<Stargazer>?, position: Int) {
        if (textDescription.text == null) {
            textDescription.text = ""
        } else {
            textDescription.text = stargazerList!!.get(position).description
            itemView.setOnClickListener {
                itemClick.getItem(adapterPosition)
            }
        }
    }
}
