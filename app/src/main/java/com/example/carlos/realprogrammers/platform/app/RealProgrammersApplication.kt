package com.example.carlos.realprogrammers.platform.app

import android.app.Application
import com.example.carlos.realprogrammers.domain.EntityGateway
import com.example.carlos.realprogrammers.platform.ServiceLocator
import com.example.carlos.realprogrammers.platform.dependencyinjection.*
import javax.inject.Inject

class RealProgrammersApplication : Application(), ServiceLocator {

    @Inject
    lateinit var entityGateway: EntityGateway


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder().build()
    }

    override fun provideProgrammerListComponentBuilder(): ProgrammerListComponent.Builder {
        return appComponent.programmersListComponentBuilder()
    }

    override fun provideProgrammerEditComponentBuilder(): ProgrammerEditComponent.Builder {
        return appComponent.programmerEditComponentBuilder()
    }

    override fun provideProgrammerDetailComponentBuilder(): ProgrammerDetailComponent.Builder {
        return appComponent.programmerDetailComponentBuilder()
    }


    companion object {
        lateinit var appComponent: ApplicationComponent
    }

}
