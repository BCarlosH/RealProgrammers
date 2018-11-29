package com.example.carlos.realprogrammersnew.platform.dependencyinjection

import com.example.carlos.realprogrammersnew.platform.views.ProgrammersListFragment
import com.example.carlos.realprogrammersnew.presentation.ProgrammersListView
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [ProgrammerListModule::class])
@FragmentScope
interface ProgrammerListComponent {

    fun inject(fragment: ProgrammersListFragment)
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun view(view: ProgrammersListView): Builder

        fun build(): ProgrammerListComponent
    }

}