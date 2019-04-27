package com.example.carlos.realprogrammers.presentation.presenters

import com.example.carlos.realprogrammers.domain.EntityGateway
import com.example.carlos.realprogrammers.domain.UseCaseFactory
import com.example.carlos.realprogrammers.domain.io.ProgrammerResponse
import com.example.carlos.realprogrammers.helpers.WeakReferenceHolder
import com.example.carlos.realprogrammers.platform.views.ProgrammerListViewHolder
import com.example.carlos.realprogrammers.presentation.ProgrammersListView
import com.example.carlos.realprogrammers.presentation.formatters.relativeString
import javax.inject.Inject

class ProgrammersListPresenter @Inject constructor(
    private val useCaseFactory: UseCaseFactory
) :
    EntityGateway.Observer {


    val numberOfProgrammers: Int
        get() = programmersList.size

    private var programmersList: List<ProgrammerResponse> = mutableListOf()

    var view: ProgrammersListView? by WeakReferenceHolder()


    fun viewReady() {
        getProgrammersList()
    }

    private fun getProgrammersList() {
        val useCaseFactory = useCaseFactory.showProgrammerListUseCase {
            programmersList = it
        }
        useCaseFactory.execute()
    }

    fun configureRow(holder: ProgrammerListViewHolder, position: Int) {
        val programmerResponse = programmersList[position]
        holder.onItemClickListener(programmerResponse.id)
        holder.displayName(programmerResponse.name)
        holder.displayDate(programmerResponse.interviewDate.relativeString())
        holder.displayFavourite(programmerResponse.favorite)
    }

    fun onProgrammerItemClick(id: String) {
        view?.navigateToDetail(id)
    }

    override fun notifyDataSetChanged() {
        getProgrammersList()
        view?.refreshView()
    }

}