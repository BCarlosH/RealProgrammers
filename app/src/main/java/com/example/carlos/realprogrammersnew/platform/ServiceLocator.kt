package com.example.carlos.realprogrammersnew.platform

import com.example.carlos.realprogrammersnew.platform.dependencyinjection.ProgrammerEditComponent
import com.example.carlos.realprogrammersnew.platform.dependencyinjection.ProgrammerListComponent

interface ServiceLocator {

    fun provideProgrammerListComponentBuilder(): ProgrammerListComponent.Builder

    fun provideProgrammerEditComponentBuilder(): ProgrammerEditComponent.Builder

}