package com.example.carlos.realprogrammersnew.platform.dependencyinjection

import com.example.carlos.realprogrammersnew.domain.UseCaseFactory
import com.example.carlos.realprogrammersnew.presentation.ProgrammerDetailView
import com.example.carlos.realprogrammersnew.presentation.presenters.ProgrammerDetailPresenter
import dagger.Module
import dagger.Provides


@Module
class ProgrammerDetailModule {

    @Provides
    fun provideProgrammerDetailPresenter(
        id: String,
        useCaseFactory: UseCaseFactory,
        view: ProgrammerDetailView
    ): ProgrammerDetailPresenter {

        return ProgrammerDetailPresenter(id, useCaseFactory).apply {
            this.view = view
        }

    }

//    @Provides
//    fun provideId() = id

}
