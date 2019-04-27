package com.example.carlos.realprogrammers.domain.io

import com.example.carlos.realprogrammers.domain.entities.RatingLevel
import com.example.carlos.realprogrammers.utils.TestData
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import java.beans.PropertyChangeListener


class ProgrammerRequestTest {

    private lateinit var programmerRequest: ProgrammerRequest
    private lateinit var listener: PropertyChangeListener


    @Before
    fun setUp() {
        listener = mock(PropertyChangeListener::class.java)
        programmerRequest = TestData.createMainProgrammerRequest()
        programmerRequest.addPropertyChangeListener(listener = listener)
    }

    @After
    fun tearDown() {
        programmerRequest.removePropertyChangeListener(listener = listener)
    }

    @Test
    fun sutIsNotNull() {
        assertNotNull(programmerRequest)
    }

    @Test
    fun constructorWithoutParametersSetsDefaultValues() {
        programmerRequest = ProgrammerRequest()
        assertTrue(programmerRequest.id.isEmpty())
        assertEquals(TestData.defaultName, programmerRequest.firstName)
        assertEquals(TestData.defaultName, programmerRequest.lastName)
        assertEquals(TestData.defaultEmacs, programmerRequest.emacs)
        assertEquals(TestData.defaultCaffeine, programmerRequest.caffeine)
        assertEquals(TestData.defaultRating, programmerRequest.realProgrammerRating)
        assertNull(programmerRequest.interviewDate)
        assertEquals(TestData.defaultFavorite, programmerRequest.favorite)
    }

    @Test
    fun setFirstNameNotifiesListener() {
        programmerRequest.firstName = TestData.altFirstName

        verify(listener).propertyChange(any())
    }

    @Test
    fun setLastNameNotifiesListener() {
        programmerRequest.lastName = TestData.altLastName

        verify(listener).propertyChange(any())
    }

    @Test
    fun setEmacsNotifiesListener() {
        programmerRequest.emacs = TestData.altEmacs

        verify(listener).propertyChange(any())
    }

    @Test
    fun setCaffeineNotifiesListener() {
        programmerRequest.caffeine = TestData.altCaffeine

        verify(listener).propertyChange(any())
    }

    @Test
    fun setInterviewDateNotifiesListener() {
        programmerRequest.interviewDate = TestData.altDate

        verify(listener).propertyChange(any())
    }

    @Test
    fun setFavoriteNotifiesListener() {
        programmerRequest.favorite = TestData.altFavorite

        verify(listener).propertyChange(any())
    }

    @Test
    fun requestIsValidIfFirstAndLastNameArentEmpty() {
        assertTrue(programmerRequest.isValid)
    }

    @Test
    fun requestIsNotValidIfFirstNameIsEmpty() {
        programmerRequest.firstName = ""

        assertFalse(programmerRequest.isValid)
    }

    @Test
    fun requestIsNotValidIfLastNameIsEmpty() {
        programmerRequest.lastName = ""

        assertFalse(programmerRequest.isValid)
    }

    @Test
    fun requestIsNotValidIfFirstAndLastNameAreEmpty() {
        programmerRequest.firstName = ""
        programmerRequest.lastName = ""

        assertFalse(programmerRequest.isValid)
    }

    @Test
    fun realProgrammerRatingIsAverageOfEmacsAndCaffeine() {
        programmerRequest.emacs = 4
        programmerRequest.caffeine = 2

        assertEquals(RatingLevel(RatingLevel.HIGH), programmerRequest.realProgrammerRating)
    }

    @Test
    fun realProgrammerRatingIsAverageOfOtherEmacsAndCaffeine() {
        programmerRequest.emacs = 0
        programmerRequest.caffeine = 2

        assertEquals(RatingLevel(RatingLevel.LOW), programmerRequest.realProgrammerRating)
    }

}