package com.example.carlos.realprogrammersnew.platform.dependencyinjection

import com.example.carlos.realprogrammersnew.data.MemoryRepository
import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.IdentityGenerator
import com.example.carlos.realprogrammersnew.domain.entities.Programmer
import com.example.carlos.realprogrammersnew.domain.services.UUIDIdentityGenerator
import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Singleton

@Module(subcomponents = [ProgrammerListComponent::class])
class ApplicationModule {


    @Provides
    @Singleton
    fun provideIdentityGenerator(): IdentityGenerator = UUIDIdentityGenerator

    @Provides
    @Singleton
    fun provideEntityGateWay(): EntityGateway {

        val list = mutableListOf(
            Programmer("asdfasdf1", "Pepe", "Viñuela", 3, 4, 4, Date(), true),
            Programmer("asdfasdf2", "Carlos", "el del al lado", 1, 2, 0, Date(), false),
            Programmer("asdfasdf3", "Ignatius", "Farray", 2, 4, 1, Date(), false),
            Programmer("asdfasdf4", "Mariano", "Rajoy", 4, 2, 3, Date(), true),
            Programmer("asdfasdf5", "Julio", "Iglesias", 1, 2, 4, Date(), false),
            Programmer("asdfasdf6", "Pepe", "Viñuela", 3, 4, 4, Date(), true),
            Programmer("asdfasdf7", "Carlos", "el del al lado", 1, 2, 0, Date(), false),
            Programmer("asdfasdf8", "Ignatius", "Farray", 2, 4, 1, Date(), false),
            Programmer("asdfasdf9", "Mariano", "Rajoy", 4, 2, 3, Date(), true),
            Programmer("asdfasdf10", "Julio", "Iglesias", 1, 2, 4, Date(), false),
            Programmer("asdfasdf11", "Pepe", "Viñuela", 3, 4, 4, Date(), true),
            Programmer("asdfasdf12", "Carlos", "el del al lado", 1, 2, 0, Date(), false),
            Programmer("asdfasdf13", "Ignatius", "Farray", 2, 4, 1, Date(), false),
            Programmer("asdfasdf14", "Mariano", "Rajoy", 4, 2, 3, Date(), true),
            Programmer("asdfasdf15", "Julio", "Iglesias", 1, 2, 4, Date(), false),
            Programmer("asdfasdf16", "Pepe", "Viñuela", 3, 4, 4, Date(), true),
            Programmer("asdfasdf17", "Carlos", "el del al lado", 1, 2, 0, Date(), false),
            Programmer("asdfasdf18", "Ignatius", "Farray", 2, 4, 1, Date(), false),
            Programmer("asdfasdf19", "Mariano", "Rajoy", 4, 2, 3, Date(), true),
            Programmer("asdfasdf20", "Julio", "Iglesias", 1, 2, 4, Date(), false)
        )

        return MemoryRepository(list)
    }

}