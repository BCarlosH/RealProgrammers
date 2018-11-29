package com.example.carlos.realprogrammersnew.domain

import com.example.carlos.realprogrammersnew.domain.entities.Programmer

interface EntityGateway {

    fun fetchProgrammers(): MutableList<Programmer>
    fun addProgrammer(programmer: Programmer)
    fun addProgrammersObserver(observer: Observer)
    fun getProgrammer(id: String): Programmer?

    interface Observer {
        fun notifyDataSetChanged()
    }

}