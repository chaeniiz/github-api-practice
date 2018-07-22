package com.chaeniiz.githubapipractice

import com.chaeniiz.githubapipractice.viewholder.StargazerViewType

data class Stargazer (
    val name: String,
    val description: String,
    val type: StargazerViewType
)