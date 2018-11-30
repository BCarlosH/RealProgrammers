package com.example.carlos.realprogrammersnew.platform.dependencyinjection

import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.UseCaseFactory
import com.example.carlos.realprogrammersnew.presentation.ProgrammersListView
import com.example.carlos.realprogrammersnew.presentation.presenters.ProgrammersListPresenter
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