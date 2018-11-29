package com.example.carlos.realprogrammersnew.presentation.presenters

import com.example.carlos.realprogrammersnew.domain.usecases.ShowProgrammerUseCase
import com.example.carlos.realprogrammersnew.helpers.WeakReferenceHolder
import com.example.carlos.realprogrammersnew.presentation.ProgrammerDetailView

class ProgrammerDetailPresenter @javax.inject.Inject constructor(
    private val id: String,
    private val useCase: ShowProgrammerUseCase

) {

    var view: ProgrammerDetailView? by WeakReferenceHolder()

    //TODO: llamar a la vista con los datos

}