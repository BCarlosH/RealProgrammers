package com.example.carlos.realprogrammersnew.domain.usecases

import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.UseCase
import com.example.carlos.realprogrammersnew.domain.handler
import com.example.carlos.realprogrammersnew.domain.io.ProgrammerResponse
import javax.inject.Inject

class ShowProgrammersListUseCase @Inject constructor(
    private val entityGateway: EntityGateway,
    private val completion: handler<List<ProgrammerResponse>>

) : UseCase {

    override fun execute() {
        // get data
        val programmers = entityGateway.fetchProgrammers()

        // transformar datos
        val responses = programmers.map { ProgrammerResponse(it) }

        // pasar datos al presenter
        completion(responses)
    }

}