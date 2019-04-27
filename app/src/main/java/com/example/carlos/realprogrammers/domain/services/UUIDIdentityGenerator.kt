package com.example.carlos.realprogrammers.domain.services

import com.example.carlos.realprogrammers.domain.IdentityGenerator
import java.util.*


class UUIDIdentityGenerator {

    companion object : IdentityGenerator {
        override fun generateId(): String = UUID.randomUUID().toString()
    }

}