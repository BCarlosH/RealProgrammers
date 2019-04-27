package com.example.carlos.realprogrammers.platform.dependencyinjection

import com.example.carlos.realprogrammers.platform.views.ProgrammerEditFragment
import com.example.carlos.realprogrammers.presentation.ProgrammerEditView
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