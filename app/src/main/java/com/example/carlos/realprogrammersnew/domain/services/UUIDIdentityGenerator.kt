package com.example.carlos.realprogrammersnew.domain.services

import com.example.carlos.realprogrammersnew.domain.IdentityGenerator
import java.util.*


class UUIDIdentityGenerator {

    companion object : IdentityGenerator {
        override fun generateId(): String = UUID.randomUUID().toString()
    }

}