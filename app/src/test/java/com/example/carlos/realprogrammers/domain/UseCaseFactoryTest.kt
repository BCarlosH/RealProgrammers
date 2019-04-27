package com.example.carlos.realprogrammers.domain

import com.example.carlos.realprogrammers.domain.usecases.AddProgrammerUseCase
import com.example.carlos.realprogrammers.domain.usecases.ShowProgrammerUseCase
import com.example.carlos.realprogrammers.domain.usecases.ShowProgrammersListUseCase
import com.example.carlos.realprogrammers.domain.usecases.ToggleFavoriteUseCase
import com.example.carlos.realprogrammers.utils.TestData
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class UseCaseFactoryTest {

    lateinit var useCaseFactory: UseCaseFactory
    lateinit var entityGateway: EntityGateway


    @Before
    fun setUp() {
        entityGateway = mock(EntityGateway::class.java)
        useCaseFactory = UseCaseFactory(entityGateway = entityGateway)
    }

    @Test
    fun sutIsNotNull() {
        assertNotNull(useCaseFactory)
    }

    @Test
    fun factoryCreatesAddNewProgrammerUseCase() {
        val useCase = useCaseFactory.addProgrammerUseCase(TestData.createMainProgrammerRequest()) {}

        assertNotNull(useCase as? AddProgrammerUseCase)
    }

    @Test
    fun factoryCreatesToggleFavoriteUseCase() {
        val useCase = useCaseFactory.toggleFavouriteStateUseCase(programmerId = TestData.mainId, isFavourite = true) {}

        assertNotNull(useCase as? ToggleFavoriteUseCase)
    }

    @Test
    fun factoryCreatesShowProgrammerUseCase() {
        val useCase = useCaseFactory.showProgrammerUseCase(programmerId = TestData.mainId) {}

        assertNotNull(useCase as? ShowProgrammerUseCase)
    }

    @Test
    fun factoryCreatesShowProgrammersListUseCase() {
        val useCase = useCaseFactory.showProgrammerListUseCase {}

        assertNotNull(useCase as? ShowProgrammersListUseCase)
    }

}