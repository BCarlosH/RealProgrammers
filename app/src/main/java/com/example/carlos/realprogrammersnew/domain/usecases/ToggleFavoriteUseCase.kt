package com.example.carlos.realprogrammersnew.domain.usecases

import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.UseCase
import com.example.carlos.realprogrammersnew.domain.handler
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val entityGateway: EntityGateway,
    private val completion: handler<Unit>,
    private val programmerId: String,
    private val isFavourite: Boolean
) : UseCase {

    override fun execute() {
        entityGateway.getProgrammer(programmerId)?.let {
            val programmer = it.copy(favorite = isFavourite)
            entityGateway.updateProgrammer(programmer)
            completion(Unit)
        }
    }

//    fun toggleFavouriteState(programmerId: String, isFavourite: Boolean) {
//
//    }

}