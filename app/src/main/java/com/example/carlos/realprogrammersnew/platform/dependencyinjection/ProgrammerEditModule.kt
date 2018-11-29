package com.example.carlos.realprogrammersnew.platform.dependencyinjection

import com.example.carlos.realprogrammersnew.domain.usecases.AddProgrammerUseCase
import com.example.carlos.realprogrammersnew.presentation.ProgrammerEditView
import com.example.carlos.realprogrammersnew.presentation.presenters.ProgrammerEditPresenter
import dagger.Module
import dagger.Provides

@Module
class ProgrammerEditModule {

    @Provides
    fun providesProgrammerEditPresenter(
        addProgrammerUseCase: AddProgrammerUseCase,
        view: ProgrammerEditView
    ): ProgrammerEditPresenter {

        return ProgrammerEditPresenter(addProgrammerUseCase).apply {
            this.view = view
            addProgrammerUseCase.presenter = this
        }
    }
}