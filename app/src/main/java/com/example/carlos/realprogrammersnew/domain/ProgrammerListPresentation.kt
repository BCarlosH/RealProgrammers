package com.example.carlos.realprogrammersnew.domain

import com.example.carlos.realprogrammersnew.domain.io.ProgrammerResponse
import com.example.carlos.realprogrammersnew.platform.views.ProgrammerListViewHolder

interface ProgrammerListPresentation {

    fun showProgramerResponses(list: List<ProgrammerResponse>)
    fun viewReady()
    fun configureRow(holder: ProgrammerListViewHolder, position: Int)

}