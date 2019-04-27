package com.example.carlos.realprogrammers.presentation.presenters

import com.example.carlos.realprogrammers.domain.UseCase
import com.example.carlos.realprogrammers.domain.UseCaseFactory
import com.example.carlos.realprogrammers.presentation.ProgrammersListView
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test


class ProgrammersListPresenterTest {

    lateinit var programmersListPresenter: ProgrammersListPresenter
    lateinit var useCaseFactory: UseCaseFactory
    lateinit var view: ProgrammersListView
    lateinit var useCase: UseCase


    @Before
    fun setUp() {
        useCaseFactory = mock()
        programmersListPresenter = ProgrammersListPresenter(useCaseFactory = useCaseFactory)
        view = mock()
        programmersListPresenter.view = view
        useCase = mock()
        whenever(useCaseFactory.showProgrammerListUseCase(any())).thenReturn(useCase)
    }

    @Test
    fun sutIsNotNull() {
        assertNotNull(programmersListPresenter)
    }

    @Test
    fun viewReadyInvokesUseCase() {
        val useCase: UseCase = mock()
        whenever(useCaseFactory.showProgrammerListUseCase(completion = any())).thenReturn(useCase)

        programmersListPresenter.viewReady()

        verify(useCase).execute()
    }

    @Test
    fun modelNotificationExecutesShowProgrammersListUseCase() {
        val useCase: UseCase = mock()
        whenever(useCaseFactory.showProgrammerListUseCase(completion = any())).thenReturn(useCase)

        programmersListPresenter.notifyDataSetChanged()

        verify(useCase).execute()
    }

}