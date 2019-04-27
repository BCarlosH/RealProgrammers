package com.example.carlos.realprogrammers.domain

import com.example.carlos.realprogrammers.domain.entities.Programmer

interface EntityGateway {

    fun fetchProgrammers(): MutableList<Programmer>
    fun addProgrammer(programmer: Programmer)
    fun addProgrammersObserver(observer: Observer)
    fun getProgrammer(id: String): Programmer?
    fun updateProgrammer(programmer: Programmer)

    interface Observer {
        fun notifyDataSetChanged()
    }

}