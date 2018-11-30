package com.example.carlos.realprogrammersnew.domain

typealias handler <T> = (T) -> Unit

interface UseCase {

    fun execute()

}