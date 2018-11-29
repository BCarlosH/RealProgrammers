package com.example.carlos.realprogrammersnew.platform.dependencyinjection

import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.usecases.ShowProgrammersListUseCase
import com.example.carlos.realprogrammersnew.presentation.ProgrammersListView
import com.example.carlos.realprogrammersnew.presentation.presenters.ProgrammersListPresenter
import dagger.Module
import dagger.Provides

@Module
class ProgrammerListModule {

    @Provides
    fun providesProgrammersListPresenter(
        showProgrammersListUseCase: ShowProgrammersListUseCase,
        view: ProgrammersListView,
        entityGateway: EntityGateway
    ): ProgrammersListPresenter {

        return ProgrammersListPresenter(showProgrammersListUseCase).apply {
            this.view = view
            showProgrammersListUseCase.presenter = this
            entityGateway.addProgrammersObserver(this)
        }
    }

}