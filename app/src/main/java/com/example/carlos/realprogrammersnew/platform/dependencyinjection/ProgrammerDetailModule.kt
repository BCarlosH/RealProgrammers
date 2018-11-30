package com.example.carlos.realprogrammersnew.platform.dependencyinjection

import com.example.carlos.realprogrammersnew.domain.usecases.ShowProgrammerUseCase
import com.example.carlos.realprogrammersnew.presentation.ProgrammerDetailView
import com.example.carlos.realprogrammersnew.presentation.presenters.ProgrammerDetailPresenter
import dagger.Module
import dagger.Provides


@Module
class ProgrammerDetailModule {

    @Provides
    fun provideProgrammerDetailPresenter(
        id: String,
        showProgrammerUseCase: ShowProgrammerUseCase,
        view: ProgrammerDetailView
    ): ProgrammerDetailPresenter {

        return ProgrammerDetailPresenter(id, showProgrammerUseCase).apply {
            this.view = view
            showProgrammerUseCase.presenter = this
        }

    }

//    @Provides
//    fun provideId() = id

}
