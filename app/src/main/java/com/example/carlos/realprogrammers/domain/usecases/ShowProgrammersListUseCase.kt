package com.example.carlos.realprogrammers.domain.usecases

import com.example.carlos.realprogrammers.domain.EntityGateway
import com.example.carlos.realprogrammers.domain.UseCase
import com.example.carlos.realprogrammers.domain.handler
import com.example.carlos.realprogrammers.domain.io.ProgrammerResponse
import javax.inject.Inject

class ShowProgrammersListUseCase @Inject constructor(
    private val entityGateway: EntityGateway,
    private val completion: handler<List<ProgrammerResponse>>

) : UseCase {

    override fun execute() {

        val programmers = entityGateway.fetchProgrammers()
        val responses = programmers.map { ProgrammerResponse(it) }
        completion(responses)
    }

}