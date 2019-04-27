package com.example.carlos.realprogrammers.platform.dependencyinjection

import com.example.carlos.realprogrammers.platform.views.ProgrammerDetailFragment
import com.example.carlos.realprogrammers.presentation.ProgrammerDetailView
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

        @BindsInstance
        fun programmerId(id: String)

        fun build(): ProgrammerDetailComponent
    }

}