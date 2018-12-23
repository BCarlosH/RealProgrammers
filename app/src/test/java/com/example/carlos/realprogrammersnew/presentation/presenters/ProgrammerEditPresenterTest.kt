package com.example.carlos.realprogrammersnew.presentation.presenters

import com.example.carlos.realprogrammersnew.domain.UseCase
import com.example.carlos.realprogrammersnew.domain.UseCaseFactory
import com.example.carlos.realprogrammersnew.domain.entities.RatingLevel
import com.example.carlos.realprogrammersnew.presentation.ProgrammerEditView
import com.example.carlos.realprogrammersnew.utils.TestData
import com.nhaarman.mockitokotlin2.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class ProgrammerEditPresenterTest {

    lateinit var programmerEditPresenter: ProgrammerEditPresenter
    lateinit var view: ProgrammerEditView
    lateinit var useCaseFactory: UseCaseFactory


    @Before
    fun setUp() {
        view = mock()
        useCaseFactory = mock()
        programmerEditPresenter = ProgrammerEditPresenter(useCaseFactory = useCaseFactory)
        programmerEditPresenter.view = view
    }

    @Test
    fun sutIsNotNull() {
        assertNotNull(programmerEditPresenter)
    }

    @Test
    fun viewReadyConfiguresFirstNameTextField() {
        programmerEditPresenter.viewReady()

        argumentCaptor<String>().apply {
            verify(view).setUpFirstNameEntry(capture())
            assertEquals(TestData.defaultName, lastValue)
        }
    }

    @Test
    fun viewReadyConfiguresLastNameTextField() {
        programmerEditPresenter.viewReady()

        argumentCaptor<String>().apply {
            verify(view).setUpLastNameEntry(capture())
            assertEquals(TestData.defaultName, lastValue)
        }
    }

    @Test
    fun viewReadyConfiguresFavorite() {
        programmerEditPresenter.viewReady()

        argumentCaptor<Boolean>().apply {
            verify(view).setUpFavorite(capture())
            assertEquals(TestData.defaultFavorite, lastValue)
        }
    }

    @Test
    fun viewReadyDisplaysEmacsLabel() {
        programmerEditPresenter.viewReady()

        argumentCaptor<Int>().apply {
            verify(view).displayEmacs(capture())
            assertEquals(2, lastValue)
        }
    }

    @Test
    fun viewReadyConfiguresEmacsSetter() {
        programmerEditPresenter.viewReady()

        argumentCaptor<Int>().apply {
            verify(view).setUpEmacsValue(capture())
            assertEquals(TestData.defaultEmacs, lastValue)
        }
    }

    @Test
    fun viewReadyDisplaysCaffeineLabel() {
        programmerEditPresenter.viewReady()

        argumentCaptor<Int>().apply {
            verify(view).displayCaffeine(capture())
            assertEquals(2, lastValue)
        }
    }

    @Test
    fun viewReadyConfiguresCaffeineSetter() {
        programmerEditPresenter.viewReady()

        argumentCaptor<Int>().apply {
            verify(view).setUpCaffeineValue(capture())
            assertEquals(TestData.defaultCaffeine, lastValue)
        }
    }

    @Test
    fun viewReadyDisplaysRating() {
        val ratingCaptor = argumentCaptor<Int>()
        val ratingColorCaptor = argumentCaptor<Int>()

        programmerEditPresenter.viewReady()

        verify(view).displayRealProgrammerRating(
            value = ratingCaptor.capture(),
            colorCode = ratingColorCaptor.capture()
        )
        assertEquals(TestData.defaultRating.ratingValue, ratingCaptor.lastValue)
        assertEquals(TestData.defaultRatingColor, ratingColorCaptor.lastValue)
    }

    @Test
    fun viewReadyConfiguresSaveButton() {
        programmerEditPresenter.viewReady()

        argumentCaptor<Boolean>().apply {
            verify(view).enableSaveButton(capture())
            assertFalse(lastValue)
        }
    }

    @Test
    fun emacsChangeUpdatesEmacsLabel() {
        programmerEditPresenter.viewReady()

        programmerEditPresenter.emacsChanged(4)

        argumentCaptor<Int>().apply {
            verify(view, atLeastOnce()).displayEmacs(capture())
            assertEquals(4, lastValue)
        }
    }

    @Test
    fun caffeineChangeUpdatesCaffeineLabel() {
        programmerEditPresenter.viewReady()

        programmerEditPresenter.caffeineChanged(4)

        argumentCaptor<Int>().apply {
            verify(view, atLeastOnce()).displayCaffeine(capture())
            assertEquals(4, lastValue)
        }
    }

    @Test
    fun emacsChangeUpdatesRatingIndicator() {
        val captorValue = argumentCaptor<Int>()
        val captorColorCode = argumentCaptor<Int>()
        programmerEditPresenter.viewReady()

        programmerEditPresenter.emacsChanged(4)

        verify(view, atLeastOnce()).displayRealProgrammerRating(captorValue.capture(), captorColorCode.capture())
        assertEquals(Integer.valueOf(RatingLevel.HIGH), captorValue.lastValue)
        assertEquals(RatingLevel.COLOR_GOOD, captorColorCode.lastValue)
    }

    @Test
    fun caffeineChangeUpdatesRatingIndicator() {
        val captorValue = argumentCaptor<Int>()
        val captorColorCode = argumentCaptor<Int>()
        programmerEditPresenter.viewReady()

        programmerEditPresenter.caffeineChanged(4)

        verify(view, atLeastOnce()).displayRealProgrammerRating(captorValue.capture(), captorColorCode.capture())
        assertEquals(Integer.valueOf(RatingLevel.HIGH), captorValue.lastValue)
        assertEquals(RatingLevel.COLOR_GOOD, captorColorCode.lastValue)
    }

    @Test
    fun firstNameChangeWithLongStringEnablesSaveButton() {
        programmerEditPresenter.viewReady()
        programmerEditPresenter.lastNameChanged(TestData.mainLastName)

        programmerEditPresenter.firstNameChanged(TestData.mainFirstName)

        argumentCaptor<Boolean>().apply {
            verify(view, atLeastOnce()).enableSaveButton(capture())
            assertTrue(lastValue)
        }
    }

    @Test
    fun lastNameChangeWithLongStringEnablesSaveButton() {
        programmerEditPresenter.viewReady()
        programmerEditPresenter.firstNameChanged(TestData.mainFirstName)

        programmerEditPresenter.lastNameChanged(TestData.mainLastName)

        argumentCaptor<Boolean>().apply {
            verify(view, atLeastOnce()).enableSaveButton(capture())
            assertTrue(lastValue)
        }
    }

    @Test
    fun firstNameChangeWithShortStringDisablesSaveButton() {
        programmerEditPresenter.viewReady()
        programmerEditPresenter.firstNameChanged(TestData.mainFirstName)
        programmerEditPresenter.lastNameChanged(TestData.mainLastName)

        programmerEditPresenter.firstNameChanged("")

        argumentCaptor<Boolean>().apply {
            verify(view, atLeastOnce()).enableSaveButton(capture())
            assertFalse(lastValue)
        }
    }

    @Test
    fun nameChangeWithShortStringDisablesSaveButton() {
        programmerEditPresenter.viewReady()
        programmerEditPresenter.firstNameChanged(TestData.mainFirstName)
        programmerEditPresenter.lastNameChanged(TestData.mainLastName)

        programmerEditPresenter.lastNameChanged("")

        argumentCaptor<Boolean>().apply {
            verify(view, atLeastOnce()).enableSaveButton(capture())
            assertFalse(lastValue)
        }
    }

    @Test
    fun saveExecutesAddNewProgrammerUseCase() {
        val useCase: UseCase = mock()
        whenever(useCaseFactory.addProgrammerUseCase(programmerRequest = any(), completion = any())).thenReturn(useCase)

        programmerEditPresenter.save()

        verify(useCase).execute()
    }

}