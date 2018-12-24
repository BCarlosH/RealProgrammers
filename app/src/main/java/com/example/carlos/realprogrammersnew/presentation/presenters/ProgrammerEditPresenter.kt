package com.example.carlos.realprogrammersnew.presentation.presenters

import com.example.carlos.realprogrammersnew.domain.UseCaseFactory
import com.example.carlos.realprogrammersnew.domain.io.ProgrammerRequest
import com.example.carlos.realprogrammersnew.helpers.WeakReferenceHolder
import com.example.carlos.realprogrammersnew.presentation.ProgrammerEditView
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