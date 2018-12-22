package com.example.carlos.realprogrammersnew.domain.usecases

import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.entities.Programmer
import com.example.carlos.realprogrammersnew.domain.io.ProgrammerResponse
import com.example.carlos.realprogrammersnew.utils.TestData
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import java.lang.ref.WeakReference

class ShowProgrammersListUseCaseTest {

    lateinit var showProgrammersListUseCase: ShowProgrammersListUseCase
    lateinit var entityGateway: EntityGateway
    lateinit var programmerResponse: List<ProgrammerResponse>


    @Before
    fun setUp() {
        val thisRef = WeakReference(this)
        entityGateway = mock(EntityGateway::class.java)
        showProgrammersListUseCase = ShowProgrammersListUseCase(entityGateway = entityGateway) { result ->
            thisRef.get()?.apply {
                programmerResponse = result
            }
        }
    }

    @Test
    fun sutIsNotNull() {
        assertNotNull(showProgrammersListUseCase)
    }

    @Test
    fun repoWithNoEntitiesGeneratesNoProgrammerResponses() {
        showProgrammersListUseCase.execute()

        assertEquals(0, programmerResponse.size)
    }

    @Test
    fun transformsProgrammerEntityIntoResponse() {
        val programmers = listOf(TestData.createMainProgrammer())
        passData(programmers)

        showProgrammersListUseCase.execute()

        assertEquals(listOf(TestData.createMainProgrammerResponse()), programmerResponse)
    }

    @Test
    fun transformsTwoProgrammerEntitiesIntoResponses() {
        val programmers = listOf(TestData.createMainProgrammer(), TestData.createAltProgrammer())
        passData(programmers)

        showProgrammersListUseCase.execute()

        assertEquals(
            listOf(
                TestData.createMainProgrammerResponse(),
                TestData.createAltProgrammerResponse()
            ), programmerResponse
        )
    }

    private fun passData(programmers: List<Programmer>) {
        doReturn(programmers).whenever(entityGateway).fetchProgrammers()
    }

}