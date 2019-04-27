package com.example.carlos.realprogrammers.presentation

interface ProgrammerDetailView {

    fun displayFirstName(firstName: String)
    fun displayLastName(lastName: String)
    fun setUpFavorite(favorite: Boolean)
    fun displayEmacs(emacsValue: Int?)
    fun displayCaffeine(caffeineValue: Int?)
    fun displayRealProgrammerRating(value: Int, colorCode: Int)

}