package com.example.carlos.realprogrammers.platform.dependencyinjection

import com.example.carlos.realprogrammers.domain.UseCaseFactory
import com.example.carlos.realprogrammers.presentation.ProgrammerDetailView
import com.example.carlos.realprogrammers.presentation.presenters.ProgrammerDetailPresenter
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

}
