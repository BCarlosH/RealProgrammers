package com.example.carlos.realprogrammersnew.platform.views

import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.carlos.realprogrammersnew.R
import com.example.carlos.realprogrammersnew.domain.io.ProgrammerResponse
import com.example.carlos.realprogrammersnew.presentation.presenters.ProgrammersListPresenter

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