package com.example.carlos.realprogrammersnew.platform.dependencyinjection

import com.example.carlos.realprogrammersnew.domain.UseCaseFactory
import com.example.carlos.realprogrammersnew.presentation.ProgrammerEditView
import com.example.carlos.realprogrammersnew.presentation.presenters.ProgrammerEditPresenter
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