package com.example.carlos.realprogrammers.data

import com.example.carlos.realprogrammers.domain.EntityGateway
import com.example.carlos.realprogrammers.domain.entities.Programmer

class MemoryRepository(private var programmers: MutableList<Programmer>) : EntityGateway {


    override fun addProgrammersObserver(observer: EntityGateway.Observer) {
        observer.notifyDataSetChanged()
    }

    override fun fetchProgrammers(): MutableList<Programmer> {
        return programmers
    }

    override fun addProgrammer(programmer: Programmer) {
        programmers.add(programmer)
    }

    override fun getProgrammer(id: String): Programmer? {
        return programmers.firstOrNull {
            it.id == id
        }
    }

    override fun updateProgrammer(programmer: Programmer) {
        programmers = programmers.map {
            if (it.id == programmer.id) {
                programmer
            } else {
                it
            }
        }.toMutableList()
    }

}