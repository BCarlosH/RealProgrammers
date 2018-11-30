package com.example.carlos.realprogrammersnew.domain

import com.example.carlos.realprogrammersnew.domain.entities.Programmer
import com.example.carlos.realprogrammersnew.domain.io.ProgrammerRequest
import com.example.carlos.realprogrammersnew.domain.io.ProgrammerResponse
import com.example.carlos.realprogrammersnew.domain.usecases.AddProgrammerUseCase
import com.example.carlos.realprogrammersnew.domain.usecases.ShowProgrammerUseCase
import com.example.carlos.realprogrammersnew.domain.usecases.ShowProgrammersListUseCase
import com.example.carlos.realprogrammersnew.domain.usecases.ToggleFavoriteUseCase
import javax.inject.Inject

class UseCaseFactory @Inject constructor(private val entityGateway: EntityGateway) {

    fun showProgrammerUseCase(
        programmerId: String,
        completion: handler<Programmer?>
    ): UseCase {
        return ShowProgrammerUseCase(entityGateway, programmerId, completion)
    }

    fun showProgrammerListUseCase(
        completion: handler<List<ProgrammerResponse>>
    ): UseCase {
        return ShowProgrammersListUseCase(entityGateway, completion)
    }

    fun addProgrammerUseCase(
        programmerRequest: ProgrammerRequest,
        completion: handler<Unit>
    ): UseCase {
        return AddProgrammerUseCase(entityGateway, completion, programmerRequest)
    }

    fun toggleFavouriteStateUseCase(
        completion: handler<Unit>,
        programmerId: String,
        isFavourite: Boolean
    ): UseCase {
        return ToggleFavoriteUseCase(entityGateway, completion, programmerId, isFavourite)
    }

}