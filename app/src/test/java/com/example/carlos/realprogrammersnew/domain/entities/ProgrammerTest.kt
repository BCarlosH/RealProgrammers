package com.example.carlos.realprogrammersnew.domain.entities

import com.example.carlos.realprogrammersnew.utils.TestData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class ProgrammerTest {

    lateinit var programmer: Programmer

    @Before
    fun setUp() {
        programmer = TestData.createMainProgrammer()
    }

    @Test
    fun programmerIsNotNull() {
        assertNotNull(programmer)
    }

    @Test
    fun mainFullNameIsMainFirstNameSpaceMainLastName() {
        assertEquals(TestData.mainFullName, programmer.fullName)
    }

}