package com.example.carlos.realprogrammers.platform.views

import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.carlos.realprogrammers.R
import com.example.carlos.realprogrammers.presentation.presenters.ProgrammersListPresenter

class ProgrammerListAdapter(
    private val presenter: ProgrammersListPresenter,
    private val itemClick: (String) -> Unit
) :
    Adapter<ProgrammerListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammerListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_programmer_item, parent, false)
        return ProgrammerListViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ProgrammerListViewHolder, position: Int) {
        presenter.configureRow(holder, position)
    }

    override fun getItemCount(): Int = presenter.numberOfProgrammers

}