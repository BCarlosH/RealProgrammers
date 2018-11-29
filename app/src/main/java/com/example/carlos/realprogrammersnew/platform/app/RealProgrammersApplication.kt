package com.example.carlos.realprogrammersnew.platform.app

import android.app.Application
import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.platform.ServiceLocator
import com.example.carlos.realprogrammersnew.platform.dependencyinjection.ApplicationComponent
import com.example.carlos.realprogrammersnew.platform.dependencyinjection.DaggerApplicationComponent
import com.example.carlos.realprogrammersnew.platform.dependencyinjection.ProgrammerEditComponent
import com.example.carlos.realprogrammersnew.platform.dependencyinjection.ProgrammerListComponent
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

    companion object {
        lateinit var appComponent: ApplicationComponent
    }

}
