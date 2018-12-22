package com.example.carlos.realprogrammersnew.domain.usecases

import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.entities.Programmer
import com.example.carlos.realprogrammersnew.domain.io.ProgrammerRequest
import com.example.carlos.realprogrammersnew.utils.TestData
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock


class AddProgrammerUseCaseTest {

    lateinit var addProgrammerUseCase: AddProgrammerUseCase
    lateinit var entityGateway: EntityGateway
    lateinit var programmerRequest: ProgrammerRequest


    @Before
    fun setUp() {
        programmerRequest = TestData.createMainProgrammerRequest()
        entityGateway = mock(EntityGateway::class.java)
        addProgrammerUseCase = AddProgrammerUseCase(entityGateway = entityGateway, programmerRequest = programmerRequest) {}
    }

    @Test
    fun sutIsNotNull() {
        assertNotNull(addProgrammerUseCase)
    }

    @Test
    fun runTellsEntityGatewayToCreateProgrammer() {
        addProgrammerUseCase.execute()

        argumentCaptor<Programmer>().apply {
            verify(entityGateway).addProgrammer(capture())
            val programmer = lastValue
            assertEquals(programmerRequest.firstName, programmer.firstName)
            assertEquals(programmerRequest.lastName, programmer.lastName)
            assertEquals(programmerRequest.emacs, programmer.emacs)
            assertEquals(programmerRequest.caffeine, programmer.caffeine)
            assertEquals(programmerRequest.realProgrammerRating, programmer.realProgrammerRating)
            assertEquals(programmerRequest.favorite, programmer.favorite)
        }

    }

}