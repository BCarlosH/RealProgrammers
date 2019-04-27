package com.example.carlos.realprogrammers.platform.dependencyinjection

import com.example.carlos.realprogrammers.domain.UseCaseFactory
import com.example.carlos.realprogrammers.presentation.ProgrammerEditView
import com.example.carlos.realprogrammers.presentation.presenters.ProgrammerEditPresenter
import dagger.Module
import dagger.Provides

@Module
class ProgrammerEditModule {

    @Provides
    fun providesProgrammerEditPresenter(
        useCaseFactory: UseCaseFactory,
        view: ProgrammerEditView
    ): ProgrammerEditPresenter {

        return ProgrammerEditPresenter(useCaseFactory).apply {
            this.view = view
        }
    }
}