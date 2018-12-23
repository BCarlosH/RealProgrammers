package com.example.carlos.realprogrammersnew.presentation.presenters

import com.example.carlos.realprogrammersnew.domain.UseCase
import com.example.carlos.realprogrammersnew.domain.UseCaseFactory
import com.example.carlos.realprogrammersnew.presentation.ProgrammerDetailView
import com.example.carlos.realprogrammersnew.utils.TestData
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test


class ProgrammerDetailPresenterTest {

    lateinit var programmerDetailPresenter: ProgrammerDetailPresenter
    lateinit var useCaseFactory: UseCaseFactory
    lateinit var view: ProgrammerDetailView
    lateinit var useCase: UseCase


    @Before
    fun setUp() {
        useCaseFactory = mock()
        programmerDetailPresenter = ProgrammerDetailPresenter(id = TestData.mainId, useCaseFactory = useCaseFactory)
        view = mock()
        programmerDetailPresenter.view = view
        useCase = mock()

        whenever(
            useCaseFactory.showProgrammerUseCase(
                programmerId = any(),
                completion = any()
            )
        ).thenReturn(useCase)

        whenever(
            useCaseFactory.toggleFavouriteStateUseCase(
                programmerId = any(),
                isFavourite = any(),
                completion = any()
            )
        ).thenReturn(useCase)
    }

    @Test
    fun sutIsNotNull() {
        assertNotNull(programmerDetailPresenter)
    }

    @Test
    fun viewReadyExecutesShowProgrammerUseCase() {
        programmerDetailPresenter.viewReady()

        verify(useCase).execute()
    }

    @Test
    fun favoriteChangedInvokesToggleFavoriteUseCase() {
        programmerDetailPresenter.favoriteChanged(TestData.mainFavorite)

        verify(useCase).execute()
    }

}