package com.example.carlos.realprogrammersnew.presentation.presenters

import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.ProgrammerListPresentation
import com.example.carlos.realprogrammersnew.domain.io.ProgrammerResponse
import com.example.carlos.realprogrammersnew.domain.usecases.ShowProgrammersListUseCase
import com.example.carlos.realprogrammersnew.helpers.WeakReferenceHolder
import com.example.carlos.realprogrammersnew.platform.views.ProgrammerListViewHolder
import com.example.carlos.realprogrammersnew.presentation.ProgrammersListView
import com.example.carlos.realprogrammersnew.presentation.formatters.relativeString
import javax.inject.Inject

class ProgrammersListPresenter @Inject constructor(
    private val useCase: ShowProgrammersListUseCase
) :
    ProgrammerListPresentation, EntityGateway.Observer {


    val numberOfProgrammers: Int
        get() = programmersList.size

    private var programmersList: List<ProgrammerResponse> = mutableListOf()

    var view: ProgrammersListView? by WeakReferenceHolder()


    override fun viewReady() {
        useCase.showProgrammers()
    }

    override fun configureRow(holder: ProgrammerListViewHolder, position: Int) {
        val programmerResponse = programmersList[position]
        holder.onItemClickListener(programmerResponse.id)
        holder.displayName(programmerResponse.name)
        holder.displayDate(programmerResponse.interviewDate.relativeString())
        holder.displayFavourite(programmerResponse.favorite)
    }

    override fun showProgramerResponses(list: List<ProgrammerResponse>) {
        programmersList = list
    }

    override fun notifyDataSetChanged() {
        useCase.showProgrammers()
        view?.refreshView()
    }

}