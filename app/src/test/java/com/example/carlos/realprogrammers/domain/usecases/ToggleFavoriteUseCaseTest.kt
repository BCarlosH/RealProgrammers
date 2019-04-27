package com.example.carlos.realprogrammers.domain.usecases

import com.example.carlos.realprogrammers.domain.EntityGateway
import com.example.carlos.realprogrammers.domain.entities.Programmer
import com.example.carlos.realprogrammers.utils.TestData
import com.nhaarman.mockitokotlin2.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class ToggleFavoriteUseCaseTest {

    lateinit var toggleFavoriteUseCase: ToggleFavoriteUseCase
    lateinit var entityGateway: EntityGateway


    @Before
    fun setUp() {
        entityGateway = Mockito.mock(EntityGateway::class.java)
        toggleFavoriteUseCase = ToggleFavoriteUseCase(entityGateway, TestData.mainId, TestData.altFavorite) {}
    }

    @Test
    fun sutIsNotNull() {
        assertNotNull(toggleFavoriteUseCase)
    }

    @Test
    fun executeTellsEntityGatewayToGetProgrammer() {
        val programmer = TestData.createMainProgrammer()
        passProgrammer(programmer)

        toggleFavoriteUseCase.execute()

        argumentCaptor<String>().apply {
            verify(entityGateway).getProgrammer(id = capture())
            assertEquals(TestData.mainId, lastValue)
        }
    }

    @Test
    fun executeTellsEntityGatewayToUpdateProgrammer() {
        val programmer = TestData.createMainProgrammer()
        passProgrammer(programmer)

        toggleFavoriteUseCase.execute()

        verify(entityGateway).updateProgrammer(programmer = any())
    }

    @Test
    fun nonExistingIdDoesntInvokeUpdate() {
        toggleFavoriteUseCase = ToggleFavoriteUseCase(entityGateway, "Wrong_ID", TestData.altFavorite) {}

        toggleFavoriteUseCase.execute()

        verify(entityGateway, never()).updateProgrammer(programmer = any())
    }

    @Test
    fun programmerToBeUpdatedHasSameDataAsRetrievedButFavorite() {
        val programmer = TestData.createMainProgrammer()
        passProgrammer(programmer)

        toggleFavoriteUseCase.execute()

        argumentCaptor<Programmer>().apply {
            verify(entityGateway).updateProgrammer(programmer = capture())
            lastValue.let {
                assertEquals(TestData.mainId, it.id)
                assertEquals(TestData.mainFirstName, it.firstName)
                assertEquals(TestData.mainLastName, it.lastName)
                assertEquals(TestData.mainEmacs, it.emacs)
                assertEquals(TestData.mainCaffeine, it.caffeine)
                assertEquals(TestData.mainRealProgrammerRating, it.realProgrammerRating)
                assertEquals(TestData.mainDate, it.interviewDate)
                assertNotEquals(TestData.mainFavorite, it.favorite)
            }
        }
    }

    private fun passProgrammer(programmer: Programmer) {
        doReturn(programmer).whenever(entityGateway).getProgrammer(id = any())
    }

}