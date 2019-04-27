package com.example.carlos.realprogrammers.presentation.presenters

import com.example.carlos.realprogrammers.domain.UseCaseFactory
import com.example.carlos.realprogrammers.domain.io.ProgrammerRequest
import com.example.carlos.realprogrammers.helpers.WeakReferenceHolder
import com.example.carlos.realprogrammers.presentation.ProgrammerEditView
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import javax.inject.Inject

class ProgrammerEditPresenter @Inject constructor(
    private val useCaseFactory: UseCaseFactory
) : PropertyChangeListener {


    var view: ProgrammerEditView? by WeakReferenceHolder()
    private var programmerRequest = ProgrammerRequest()


    init {
        programmerRequest.addPropertyChangeListener(listener = this)
    }

    fun viewReady() {

        view?.apply {
            setUpFirstNameEntry(programmerRequest.firstName)
            setUpLastNameEntry(programmerRequest.lastName)
            setUpFavorite(programmerRequest.favorite)
            setUpEmacsValue(programmerRequest.emacs)
            setUpCaffeineValue(programmerRequest.caffeine)
        }
        updateView()

    }

    private fun updateView() {

        view?.apply {
            displayEmacs(emacsValue = programmerRequest.emacs)
            displayCaffeine(caffeineValue = programmerRequest.caffeine)
            displayRealProgrammerRating(
                value = programmerRequest.realProgrammerRating.ratingValue,
                colorCode = programmerRequest.realProgrammerRating.colorCode()
            )
            enableSaveButton(programmerRequest.isValid)
        }

    }

    fun firstNameChanged(newFirstName: String) {
        programmerRequest.firstName = newFirstName
    }

    fun lastNameChanged(newLastName: String) {
        programmerRequest.lastName = newLastName
    }

    fun favoriteChanged(newFavorite: Boolean) {
        programmerRequest.favorite = newFavorite
    }

    fun emacsChanged(newValue: Int) {
        programmerRequest.emacs = newValue
    }

    fun caffeineChanged(newValue: Int) {
        programmerRequest.caffeine = newValue
    }

    override fun propertyChange(event: PropertyChangeEvent?) {
        updateView()
    }

    fun save() {
        val useCaseFactory = useCaseFactory.addProgrammerUseCase(programmerRequest) {}
        useCaseFactory.execute()
    }

}