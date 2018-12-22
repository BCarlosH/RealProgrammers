package com.example.carlos.realprogrammersnew.domain.io

import com.example.carlos.realprogrammersnew.domain.entities.Programmer
import java.util.*

data class ProgrammerResponse(
    val id: String,
    val name: String,
    var lastName: String,
    val interviewDate: Date,
    val favorite: Boolean
//    val emacsValue: Int,
//    val caffeineValue: Int,
//    val realProgrammingRate: Int
) {

    constructor(programmer: Programmer) : this(
        id = programmer.id, name = programmer.firstName, lastName = programmer.lastName,
        interviewDate = programmer.interviewDate, favorite = programmer.favorite
    )

}