package com.chaeniiz.githubapipractice

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.chaeniiz.githubapipractice.viewholder.StargazerDescriptionViewHolder
import com.chaeniiz.githubapipractice.viewholder.StargazerNameViewHolder
import com.chaeniiz.githubapipractice.viewholder.StargazerViewType

class StargazerAdapter(var stargazerList: ArrayList<Stargazer>?, var itemClick: StargazerClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        return if(position % 2 == 0) {
            StargazerViewType.NAME.typeValue
        } else {
            StargazerViewType.DESCRIPTION.typeValue
        }
    }

    override fun getItemCount(): Int {
        return stargazerList!!.size
    }

    interface StargazerClickListener {
        fun getItem(position: Int)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is StargazerNameViewHolder -> {
                holder.bind(stargazerList, position)
            }
            is StargazerDescriptionViewHolder -> {
                holder.bind(stargazerList, position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                StargazerViewType.NAME.typeValue -> {
                    StargazerNameViewHolder(
                            LayoutInflater.from(parent.context).inflate(R.layout.item_stargazer, parent, false)
                            , itemClick)
                }
                StargazerViewType.DESCRIPTION.typeValue -> {
                    StargazerDescriptionViewHolder(
                            LayoutInflater.from(parent.context).inflate(R.layout.item_stargazer_description, parent, false)
                            , itemClick)
                }
                else -> {
                    StargazerDescriptionViewHolder(
                            LayoutInflater.from(parent.context).inflate(R.layout.item_stargazer_description, parent, false)
                            , itemClick)
                }
            }

}
