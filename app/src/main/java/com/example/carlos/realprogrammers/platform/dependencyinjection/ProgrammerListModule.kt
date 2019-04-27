package com.example.carlos.realprogrammers.platform.dependencyinjection

import com.example.carlos.realprogrammers.domain.EntityGateway
import com.example.carlos.realprogrammers.domain.UseCaseFactory
import com.example.carlos.realprogrammers.presentation.ProgrammersListView
import com.example.carlos.realprogrammers.presentation.presenters.ProgrammersListPresenter
import dagger.Module
import dagger.Provides

@Module
class ProgrammerListModule {

    @Provides
    fun providesProgrammersListPresenter(
        useCaseFactory: UseCaseFactory,
        view: ProgrammersListView,
        entityGateway: EntityGateway
    ): ProgrammersListPresenter {

        return ProgrammersListPresenter(useCaseFactory).apply {
            this.view = view
            entityGateway.addProgrammersObserver(this)
        }
    }

}