package com.example.carlos.realprogrammers.domain.entities

/**
 * 20170903. Initial version created by jorge
 * for a Canonical Examples training.
 *
 * Copyright 2017 Jorge D. Ortiz Fuentes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
class RatingLevel(var ratingValue: Int) {
    companion object {
        //<editor-fold desc="Constants">
        const val LOWEST = 0
        const val LOW = 1
        const val MEDIUM = 2
        const val HIGH = 3
        const val HIGHEST = 4
        const val COLOR_WORST = 0
        const val COLOR_BAD = 1
        const val COLOR_AVERAGE = 2
        const val COLOR_GOOD = 3
        const val COLOR_BEST = 4
        //</editor-fold>
    }

    fun colorCode() = when (ratingValue) {
        LOWEST -> COLOR_WORST
        LOW -> COLOR_BAD
        MEDIUM -> COLOR_AVERAGE
        HIGH -> COLOR_GOOD
        HIGHEST -> COLOR_BEST
        else -> COLOR_WORST
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RatingLevel

        if (ratingValue != other.ratingValue) return false

        return true
    }

    override fun hashCode(): Int = ratingValue

}