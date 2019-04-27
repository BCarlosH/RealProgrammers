package com.example.carlos.realprogrammers.domain.usecases

import com.example.carlos.realprogrammers.domain.EntityGateway
import com.example.carlos.realprogrammers.domain.UseCase
import com.example.carlos.realprogrammers.domain.handler
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val entityGateway: EntityGateway,
    private val programmerId: String,
    private val isFavourite: Boolean,
    private val completion: handler<Unit>
) : UseCase {

    override fun execute() {
        entityGateway.getProgrammer(programmerId)?.let {
            val programmer = it.copy(favorite = isFavourite)
            entityGateway.updateProgrammer(programmer)
            completion(Unit)
        }
    }

}