package com.example.carlos.realprogrammersnew.platform.dependencyinjection

import com.example.carlos.realprogrammersnew.platform.views.ProgrammerDetailFragment
import com.example.carlos.realprogrammersnew.presentation.ProgrammerDetailView
import dagger.BindsInstance
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [ProgrammerDetailModule::class])
interface ProgrammerDetailComponent {

    fun inject(fragment: ProgrammerDetailFragment)
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun view(view: ProgrammerDetailView): Builder

        fun build(): ProgrammerDetailComponent
    }
}