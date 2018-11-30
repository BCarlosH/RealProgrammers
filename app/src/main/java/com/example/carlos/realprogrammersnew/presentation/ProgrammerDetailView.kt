package com.example.carlos.realprogrammersnew.presentation

interface ProgrammerDetailView {

    fun displayFirstName(firstName: String)
    fun displayLastName(lastName: String)
    fun setUpFavorite(favorite: Boolean)
    fun displayEmacs(emacsLabel: String)
    fun displayCaffeine(caffeineLabel: String)
    fun displayRealProgrammerRating(value: Int, colorCode: Int)

}