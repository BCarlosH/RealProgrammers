package com.example.carlos.realprogrammersnew.domain.usecases

import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.UseCase
import com.example.carlos.realprogrammersnew.domain.entities.Programmer
import com.example.carlos.realprogrammersnew.domain.handler
import javax.inject.Inject


class ShowProgrammerUseCase @Inject constructor(
    private val entityGateway: EntityGateway,
    private val id: String,
    private val completion: handler<Programmer?>
) : UseCase {

    override fun execute() {
        val programmer = entityGateway.getProgrammer(id)
        completion(programmer)
    }

}
