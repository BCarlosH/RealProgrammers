package com.example.carlos.realprogrammersnew.domain.usecases

import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.io.ProgrammerRequest
import com.example.carlos.realprogrammersnew.domain.services.UUIDIdentityGenerator
import com.example.carlos.realprogrammersnew.helpers.WeakReferenceHolder
import com.example.carlos.realprogrammersnew.presentation.presenters.ProgrammerEditPresenter
import java.util.*
import javax.inject.Inject

class AddProgrammerUseCase @Inject constructor(
    private val entityGateway: EntityGateway
) {

    var presenter: ProgrammerEditPresenter? by WeakReferenceHolder()


    fun addProgrammer(programmerRequest: ProgrammerRequest) {
        programmerRequest.id = UUIDIdentityGenerator.generateId()
        entityGateway.addProgrammer(programmerRequest.getProgrammer(Date()))
    }

}