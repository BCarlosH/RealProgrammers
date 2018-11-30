package com.example.carlos.realprogrammersnew.presentation.presenters

import com.example.carlos.realprogrammersnew.domain.entities.Programmer
import com.example.carlos.realprogrammersnew.domain.usecases.ShowProgrammerUseCase
import com.example.carlos.realprogrammersnew.helpers.WeakReferenceHolder
import com.example.carlos.realprogrammersnew.presentation.ProgrammerDetailView
import javax.inject.Inject

class ProgrammerDetailPresenter @Inject constructor(
    private val id: String,
    private val useCase: ShowProgrammerUseCase

) {

    var view: ProgrammerDetailView? by WeakReferenceHolder()

    lateinit var programmer: Programmer

    fun viewReady() {
        programmer = useCase.getProgrammer(id)!!
        configureView(programmer)
    }

    private fun configureView(programmer: Programmer?) {
        view?.apply {
            displayFirstName(firstName = programmer?.firstName ?: "")
            displayLastName(lastName = programmer?.lastName ?: "")
            setUpFavorite(programmer?.favorite ?: false)
            displayEmacs(emacsLabel = programmer?.emacs.toString())
            displayCaffeine(caffeineLabel = programmer?.caffeine.toString())

            //TODO: actualizar color del rating
//            displayRealProgrammerRating(value = programmer?.realProgrammerRating?.ratingValue ?: RatingLevel.LOWEST,
//                colorCode = programmer?.realProgrammerRating?.colorCode() ?: RatingLevel.COLOR_WORST)
        }
    }

    fun toggleFavouriteState(programmerId: String, isFavourite: Boolean) {

    }


}