package com.example.carlos.realprogrammersnew.domain.usecases

import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.entities.Programmer
import com.example.carlos.realprogrammersnew.utils.TestData
import com.nhaarman.mockitokotlin2.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import java.lang.ref.WeakReference

class ShowProgrammerUseCaseTest {

    lateinit var showProgrammerUseCase: ShowProgrammerUseCase
    lateinit var entityGateway: EntityGateway
    private val id = "ABCD"
    var returnedProgrammer: Programmer? = null


    @Before
    fun setUp() {
        entityGateway = mock(EntityGateway::class.java)
        val thisRef = WeakReference(this)
        showProgrammerUseCase = ShowProgrammerUseCase(entityGateway = entityGateway, id = id) { programmer ->
            thisRef.get()?.apply {
                returnedProgrammer = programmer
            }
        }
    }

    @Test
    fun sutIsNotNull() {
        assertNotNull(showProgrammerUseCase)
    }

    @Test
    fun executeInvokesEntityGatewayGetProgrammer() {
        showProgrammerUseCase.execute()

        argumentCaptor<String>().apply {
            verify(entityGateway).getProgrammer(capture())
            assertEquals(id, lastValue)
        }
    }

    @Test
    fun executeInvokesHandlerWithProgrammer() {
        doReturn(TestData.createMainProgrammer()).whenever(entityGateway).getProgrammer(id = any())

        showProgrammerUseCase.execute()

        assertEquals(TestData.createMainProgrammer(), returnedProgrammer)
    }

}