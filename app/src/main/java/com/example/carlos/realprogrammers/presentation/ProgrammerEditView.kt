package com.example.carlos.realprogrammers.presentation

interface ProgrammerEditView {

    fun setUpFirstNameEntry(firstName: String)
    fun setUpLastNameEntry(lastName: String)
    fun setUpFavorite(favorite: Boolean)
    fun displayEmacs(emacsValue: Int)
    fun setUpEmacsValue(value: Int)
    fun displayCaffeine(caffeineValue: Int)
    fun setUpCaffeineValue(value: Int)
    fun displayRealProgrammerRating(value: Int, colorCode: Int)
    fun enableSaveButton(enabled: Boolean)

}