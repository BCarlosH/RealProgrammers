package com.example.carlos.realprogrammers.platform.dependencyinjection

import com.example.carlos.realprogrammers.domain.EntityGateway
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class])
@Singleton
interface ApplicationComponent {

    fun entityGateWay(): EntityGateway
    fun programmersListComponentBuilder(): ProgrammerListComponent.Builder
    fun programmerEditComponentBuilder(): ProgrammerEditComponent.Builder
    fun programmerDetailComponentBuilder(): ProgrammerDetailComponent.Builder

}