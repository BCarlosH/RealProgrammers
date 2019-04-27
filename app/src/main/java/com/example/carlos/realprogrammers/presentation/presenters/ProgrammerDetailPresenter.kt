package com.example.carlos.realprogrammers.presentation.presenters

import com.example.carlos.realprogrammers.domain.UseCaseFactory
import com.example.carlos.realprogrammers.domain.entities.Programmer
import com.example.carlos.realprogrammers.domain.entities.RatingLevel
import com.example.carlos.realprogrammers.helpers.WeakReferenceHolder
import com.example.carlos.realprogrammers.presentation.ProgrammerDetailView
import javax.inject.Inject

class ProgrammerDetailPresenter @Inject constructor(
    private val id: String,
    private val useCaseFactory: UseCaseFactory

) {

    var view: ProgrammerDetailView? by WeakReferenceHolder()


    fun viewReady() {
        val useCaseFactory = useCaseFactory.showProgrammerUseCase(id) {
            configureView(it)
        }
        useCaseFactory.execute()
    }

    private fun configureView(programmer: Programmer?) {
        view?.apply {
            displayFirstName(firstName = programmer?.firstName ?: "")
            displayLastName(lastName = programmer?.lastName ?: "")
            setUpFavorite(programmer?.favorite ?: false)
            displayEmacs(emacsValue = programmer?.emacs)
            displayCaffeine(caffeineValue = programmer?.caffeine)
            displayRealProgrammerRating(
                value = programmer?.realProgrammerRating?.ratingValue ?: RatingLevel.LOWEST,
                colorCode = programmer?.realProgrammerRating?.colorCode() ?: RatingLevel.COLOR_WORST
            )
        }
    }

    fun favoriteChanged(isFavourite: Boolean) {
        val useCaseFactory = useCaseFactory.toggleFavouriteStateUseCase(id, isFavourite) {}
        useCaseFactory.execute()
    }

}