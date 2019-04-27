package com.example.carlos.realprogrammers.platform

import com.example.carlos.realprogrammers.platform.dependencyinjection.ProgrammerDetailComponent
import com.example.carlos.realprogrammers.platform.dependencyinjection.ProgrammerEditComponent
import com.example.carlos.realprogrammers.platform.dependencyinjection.ProgrammerListComponent

interface ServiceLocator {

    fun provideProgrammerListComponentBuilder(): ProgrammerListComponent.Builder

    fun provideProgrammerEditComponentBuilder(): ProgrammerEditComponent.Builder

    fun provideProgrammerDetailComponentBuilder(): ProgrammerDetailComponent.Builder

}