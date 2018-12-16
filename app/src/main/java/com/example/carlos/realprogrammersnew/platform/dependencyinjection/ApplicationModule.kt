package com.example.carlos.realprogrammersnew.platform.dependencyinjection

import com.example.carlos.realprogrammersnew.data.MemoryRepository
import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.IdentityGenerator
import com.example.carlos.realprogrammersnew.domain.entities.Programmer
import com.example.carlos.realprogrammersnew.domain.entities.RatingLevel
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
            Programmer("asdfasdf1", "Pepe", "Viñuela", 4, 4, RatingLevel(RatingLevel.HIGHEST), Date(), true),
            Programmer("asdfasdf2", "Eugenio", "Jofra", 1, 1, RatingLevel(RatingLevel.LOW), Date(), false),
            Programmer("asdfasdf3", "Ignatius", "Farray", 2, 4, RatingLevel(RatingLevel.HIGH), Date(), false),
            Programmer("asdfasdf4", "Pedro", "Reyes", 4, 2, RatingLevel(RatingLevel.HIGH), Date(), true),
            Programmer("asdfasdf5", "Miguel", "Noguera", 0, 0, RatingLevel(RatingLevel.LOWEST), Date(), false),
            Programmer("asdfasdf6", "Bill", "Cosby", 1, 3, RatingLevel(RatingLevel.MEDIUM), Date(), true),
            Programmer("asdfasdf7", "Rowan", "Atkinson", 3, 1, RatingLevel(RatingLevel.MEDIUM), Date(), false),
            Programmer("asdfasdf8", "Andy", "Kaufman", 3, 3, RatingLevel(RatingLevel.HIGH), Date(), false),
            Programmer("asdfasdf9", "Ernesto", "Sevilla", 4, 4, RatingLevel(RatingLevel.HIGHEST), Date(), true),
            Programmer("asdfasdf10", "Joaquin", "Reyes", 2, 4, RatingLevel(RatingLevel.HIGH), Date(), false)
        )

        return MemoryRepository(list)
    }

}