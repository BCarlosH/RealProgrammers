package com.example.carlos.realprogrammersnew.utils

import com.example.carlos.realprogrammersnew.domain.entities.Programmer
import com.example.carlos.realprogrammersnew.domain.entities.RatingLevel
import com.example.carlos.realprogrammersnew.domain.io.ProgrammerRequest
import com.example.carlos.realprogrammersnew.domain.io.ProgrammerResponse
import java.util.*


object TestData {
    val mainId = "a1b2c3d4e5f6"
    val altId = "f0e7d8c9b0a1"
    val mainFirstName = "Christian"
    val altFirstName = "Elliot"
    val mainLastName = "Slater"
    val altLastName = "Alderson"
    val mainFullName = "Christian Slater"
    val altFullName = "Elliot Alderson"
    val mainEmacs = 4
    val altEmacs = 1
    val mainCaffeine = 3
    val altCaffeine = 2
    val mainRealProgrammerRating = RatingLevel(RatingLevel.HIGH)
    val altRealProgrammerRating = RatingLevel(RatingLevel.LOW)
    val mainDate = Date(749520000000L)
    val altDate = Date(1426550400000L)
    val mainFavorite = true
    val altFavorite = false
    val defaultName = ""
    val defaultFavorite = false
    val defaultEmacs = 2
    val defaultCaffeine = 2
    val defaultRating = RatingLevel(RatingLevel.MEDIUM)
    val defaultRatingColor = RatingLevel.COLOR_AVERAGE

    fun createMainProgrammer(): Programmer =
        Programmer(
            id = mainId, firstName = mainFirstName, lastName = mainLastName,
            emacs = mainEmacs, caffeine = mainCaffeine,
            realProgrammerRating = mainRealProgrammerRating,
            interviewDate = mainDate, favorite = mainFavorite
        )

    fun createAltProgrammer(): Programmer =
        Programmer(
            id = altId, firstName = altFirstName, lastName = altLastName,
            emacs = altEmacs, caffeine = altCaffeine,
            realProgrammerRating = altRealProgrammerRating,
            interviewDate = altDate, favorite = altFavorite
        )

    fun createMainProgrammerResponse(): ProgrammerResponse =
        ProgrammerResponse(
            id = mainId,
            name = mainFirstName,
            lastName = mainLastName,
            interviewDate = mainDate,
            favorite = mainFavorite
        )

    fun createAltProgrammerResponse(): ProgrammerResponse =
        ProgrammerResponse(
            id = altId,
            name = altFirstName,
            lastName = altLastName,
            interviewDate = altDate,
            favorite = altFavorite
        )

    fun createMainProgrammerRequest(): ProgrammerRequest = ProgrammerRequest(
        id = TestData.mainId,
        firstName = TestData.mainFirstName,
        lastName = TestData.mainLastName,
        emacs = TestData.mainEmacs,
        caffeine = TestData.mainCaffeine,
        realProgrammerRating = TestData.mainRealProgrammerRating,
        interviewDate = TestData.mainDate,
        favorite = TestData.mainFavorite
    )

}