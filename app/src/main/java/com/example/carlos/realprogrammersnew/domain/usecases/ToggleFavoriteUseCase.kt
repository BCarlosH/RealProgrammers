package com.example.carlos.realprogrammersnew.domain.usecases

import com.example.carlos.realprogrammersnew.domain.EntityGateway
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val entityGateway: EntityGateway
) {

    fun toggleFavouriteState(programmerId: String, isFavourite: Boolean) {
        entityGateway.getProgrammer(programmerId)?.let {
            val programmer = it.copy(favorite = isFavourite)
            entityGateway.updateProgrammer(programmer)
        }
    }

}