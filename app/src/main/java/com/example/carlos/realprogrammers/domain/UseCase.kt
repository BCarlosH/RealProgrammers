package com.example.carlos.realprogrammers.domain

typealias handler <T> = (T) -> Unit

interface UseCase {

    fun execute()

}