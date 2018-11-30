package com.example.carlos.realprogrammersnew.platform.dependencyinjection

import com.example.carlos.realprogrammersnew.platform.views.ProgrammerEditFragment
import com.example.carlos.realprogrammersnew.presentation.ProgrammerEditView
import dagger.BindsInstance
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [ProgrammerEditModule::class])
interface ProgrammerEditComponent {

    fun inject(fragment: ProgrammerEditFragment)
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun view(view: ProgrammerEditView): Builder

        fun build(): ProgrammerEditComponent
    }

}