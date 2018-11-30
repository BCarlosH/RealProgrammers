package com.example.carlos.realprogrammersnew.domain.usecases

import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.io.ProgrammerResponse
import com.example.carlos.realprogrammersnew.helpers.WeakReferenceHolder
import com.example.carlos.realprogrammersnew.presentation.presenters.ProgrammersListPresenter
import javax.inject.Inject

class ShowProgrammersListUseCase @Inject constructor(
    private val entitiyGateway: EntityGateway
) {

    var presenter: ProgrammersListPresenter? by WeakReferenceHolder()

    fun showProgrammers() {

        // get data
        val programmers = entitiyGateway.fetchProgrammers()

        // transformar datos
        val responses = programmers.map { ProgrammerResponse(it) }

        // pasar datos al presenter
        presenter?.showProgrammerResponses(responses)

    }

}