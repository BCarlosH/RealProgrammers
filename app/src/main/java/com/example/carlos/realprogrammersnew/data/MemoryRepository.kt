package com.example.carlos.realprogrammersnew.data

import com.example.carlos.realprogrammersnew.domain.EntityGateway
import com.example.carlos.realprogrammersnew.domain.entities.Programmer
import com.example.carlos.realprogrammersnew.helpers.WeakReferenceHolder

class MemoryRepository(private val programmers: MutableList<Programmer>) : EntityGateway {


    private var observer: EntityGateway.Observer? by WeakReferenceHolder()

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


}