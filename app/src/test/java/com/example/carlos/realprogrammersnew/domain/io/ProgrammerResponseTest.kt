package com.example.carlos.realprogrammersnew.domain.io

import com.example.carlos.realprogrammersnew.utils.TestData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class ProgrammerResponseTest {

    lateinit var programmerResponse: ProgrammerResponse


    @Before
    fun setUp() {
        programmerResponse = TestData.createMainProgrammerResponse()
    }

    @Test
    fun sutIsNotNull() {
        assertNotNull(programmerResponse)
    }

    @Test
    fun idIsExtractedFromMainProgrammer() {
        programmerResponse = ProgrammerResponse(programmer = TestData.createMainProgrammer())

        assertEquals(TestData.mainId, programmerResponse.id)
    }

    @Test
    fun nameIsExtractedFromMainProgrammer() {
        programmerResponse = ProgrammerResponse(programmer = TestData.createMainProgrammer())

        assertEquals(TestData.mainFirstName, programmerResponse.name)
    }

    @Test
    fun interviewDateIsExtractedFromMainProgrammer() {
        assertEquals(TestData.mainDate, programmerResponse.interviewDate)
    }

    @Test
    fun favoriteIsExtractedFromMainProgrammer() {
        assertEquals(TestData.mainFavorite, programmerResponse.favorite)
    }

}