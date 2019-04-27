package com.example.carlos.realprogrammers.domain.entities

import java.util.*

data class Programmer(
    val id: String,
    val firstName: String,
    val lastName: String,
    val emacs: Int,
    val caffeine: Int,
    val realProgrammerRating: RatingLevel,
    val interviewDate: Date,
    val favorite: Boolean
) {


    val fullName: String
        get() = "$firstName $lastName"
}