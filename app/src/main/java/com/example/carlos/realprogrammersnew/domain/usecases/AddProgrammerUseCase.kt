package com.example.carlos.realprogrammersnew.domain.usecases

import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.UseCase
import com.example.carlos.realprogrammersnew.domain.handler
import com.example.carlos.realprogrammersnew.domain.io.ProgrammerRequest
import com.example.carlos.realprogrammersnew.domain.services.UUIDIdentityGenerator
import java.util.*
import javax.inject.Inject

class AddProgrammerUseCase @Inject constructor(
    private val entityGateway: EntityGateway,
    private val programmerRequest: ProgrammerRequest,
    private val completion: handler<Unit>
) : UseCase {

    override fun execute() {
        programmerRequest.id = UUIDIdentityGenerator.generateId()
        entityGateway.addProgrammer(programmerRequest.getProgrammer(Date()))
        completion(Unit)
    }

}