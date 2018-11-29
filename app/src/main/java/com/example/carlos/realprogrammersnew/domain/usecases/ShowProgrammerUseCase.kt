package com.example.carlos.realprogrammersnew.domain.usecases

import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.entities.Programmer
import com.example.carlos.realprogrammersnew.helpers.WeakReferenceHolder
import com.example.carlos.realprogrammersnew.presentation.presenters.ProgrammerDetailPresenter
import javax.inject.Inject


class ShowProgrammerUseCase @Inject constructor(private val entityGateway: EntityGateway) {

    var presenter: ProgrammerDetailPresenter? by WeakReferenceHolder()


    fun getProgrammer(id: String): Programmer? {
        return entityGateway.getProgrammer(id)
    }

}
