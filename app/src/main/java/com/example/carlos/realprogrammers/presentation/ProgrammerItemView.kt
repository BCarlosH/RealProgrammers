package com.example.carlos.realprogrammers.presentation

interface ProgrammerItemView {

    fun onItemClickListener(id: String)
    fun displayName(name: String)
    fun displayDate(date: String)
    fun displayFavourite(isFavourite: Boolean)

}