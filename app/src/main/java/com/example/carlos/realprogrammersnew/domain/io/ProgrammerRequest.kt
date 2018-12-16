package com.example.carlos.realprogrammersnew.domain.io

import com.example.carlos.realprogrammersnew.domain.entities.Programmer
import com.example.carlos.realprogrammersnew.domain.entities.RatingLevel
import com.example.carlos.realprogrammersnew.helpers.Observable
import java.beans.PropertyChangeSupport
import java.util.*
import kotlin.properties.Delegates
import kotlin.reflect.KProperty


class ProgrammerRequest(
    id: String?,
    firstName: String,
    lastName: String,
    emacs: Int,
    caffeine: Int,
    realProgrammerRating: RatingLevel,
    interviewDate: Date?,
    favorite: Boolean
) : Observable {

    constructor() : this(
        id = null,
        firstName = "",
        lastName = "",
        emacs = 2,
        caffeine = 2,
        realProgrammerRating = RatingLevel(RatingLevel.MEDIUM),
        interviewDate = null,
        favorite = false
    )


    private var onChange = { prop: KProperty<*>, oldValue: Any?, newValue: Any? ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }


    var id = id ?: ""

    var firstName: String by Delegates.observable(initialValue = firstName, onChange = onChange)

    var lastName: String by Delegates.observable(initialValue = lastName, onChange = onChange)

    var emacs: Int by Delegates.observable(initialValue = emacs, onChange = onChange)

    var caffeine: Int by Delegates.observable(initialValue = caffeine, onChange = onChange)

    val realProgrammerRating: RatingLevel
        get() = RatingLevel((emacs + caffeine) / 2)

    var interviewDate: Date? by Delegates.observable(initialValue = interviewDate, onChange = onChange)

    var favorite: Boolean by Delegates.observable(initialValue = favorite, onChange = onChange)

    val isValid: Boolean
        get() = !(firstName.isEmpty() || lastName.isEmpty())

    override val changeSupport = PropertyChangeSupport(this)


    fun getProgrammer(date: Date): Programmer {
        return Programmer(
            this.id,
            this.firstName,
            this.lastName,
            this.emacs,
            this.caffeine,
            this.realProgrammerRating,
            date,
            this.favorite
        )
    }


}