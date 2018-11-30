package com.example.carlos.realprogrammersnew.platform.dependencyinjection

import com.example.carlos.realprogrammersnew.platform.views.ProgrammersListFragment
import com.example.carlos.realprogrammersnew.presentation.ProgrammersListView
import dagger.BindsInstance
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [ProgrammerListModule::class])
interface ProgrammerListComponent {

    fun inject(fragment: ProgrammersListFragment)
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun view(view: ProgrammersListView): Builder

        fun build(): ProgrammerListComponent
    }

}