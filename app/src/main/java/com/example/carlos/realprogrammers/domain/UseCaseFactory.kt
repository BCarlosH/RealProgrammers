package com.example.carlos.realprogrammers.domain

import com.example.carlos.realprogrammers.domain.entities.Programmer
import com.example.carlos.realprogrammers.domain.io.ProgrammerRequest
import com.example.carlos.realprogrammers.domain.io.ProgrammerResponse
import com.example.carlos.realprogrammers.domain.usecases.AddProgrammerUseCase
import com.example.carlos.realprogrammers.domain.usecases.ShowProgrammerUseCase
import com.example.carlos.realprogrammers.domain.usecases.ShowProgrammersListUseCase
import com.example.carlos.realprogrammers.domain.usecases.ToggleFavoriteUseCase
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
        return AddProgrammerUseCase(entityGateway, programmerRequest, completion)
    }

    fun toggleFavouriteStateUseCase(
        programmerId: String,
        isFavourite: Boolean,
        completion: handler<Unit>
    ): UseCase {
        return ToggleFavoriteUseCase(entityGateway, programmerId, isFavourite, completion)
    }

}