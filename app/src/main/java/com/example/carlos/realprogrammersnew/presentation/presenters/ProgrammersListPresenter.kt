package com.example.carlos.realprogrammersnew.presentation.presenters

import com.example.carlos.realprogrammersnew.domain.EntityGateway
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
    EntityGateway.Observer {


    val numberOfProgrammers: Int
        get() = programmersList.size

    private var programmersList: List<ProgrammerResponse> = mutableListOf()

    var view: ProgrammersListView? by WeakReferenceHolder()


    fun viewReady() {
        useCase.showProgrammers()
    }

    fun configureRow(holder: ProgrammerListViewHolder, position: Int) {
        val programmerResponse = programmersList[position]
        holder.onItemClickListener(programmerResponse.id)
        holder.displayName(programmerResponse.name)
        holder.displayDate(programmerResponse.interviewDate.relativeString())
        holder.displayFavourite(programmerResponse.favorite)
    }

    fun showProgrammerResponses(list: List<ProgrammerResponse>) {
        programmersList = list
    }

    fun onProgrammerItemClick(id: String) {
        view?.navigateToDetail(id)
    }

    override fun notifyDataSetChanged() {
        useCase.showProgrammers()
        view?.refreshView()
    }

}