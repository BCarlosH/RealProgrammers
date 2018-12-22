package com.example.carlos.realprogrammersnew.domain.entities

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test


class RatingLevelTest {

    @Test
    fun highestLevelReturnsColorBest() {
        assertEquals(RatingLevel.COLOR_BEST, RatingLevel(RatingLevel.HIGHEST).colorCode())
    }

    @Test
    fun highLevelReturnsColorGood() {
        assertEquals(RatingLevel.COLOR_GOOD, RatingLevel(RatingLevel.HIGH).colorCode())
    }

    @Test
    fun mediumLevelReturnsColorAverage() {
        assertEquals(RatingLevel.COLOR_AVERAGE, RatingLevel(RatingLevel.MEDIUM).colorCode())
    }

    @Test
    fun lowLevelReturnsColorBad() {
        assertEquals(RatingLevel.COLOR_BAD, RatingLevel(RatingLevel.LOW).colorCode())
    }

    @Test
    fun lowestLevelReturnsColorWorst() {
        assertEquals(RatingLevel.COLOR_WORST, RatingLevel(RatingLevel.LOWEST).colorCode())
    }

    @Test
    fun isEqualIfLevelIsSame() {
        assertEquals(RatingLevel(RatingLevel.HIGHEST), RatingLevel(RatingLevel.HIGHEST))
    }

    @Test
    fun isNotEqualIfLevelIsNotSame() {
        assertNotEquals(RatingLevel(RatingLevel.LOWEST), RatingLevel(RatingLevel.HIGHEST))
    }

    @Test
    fun hashCodeIsEqualIfLevelIsSame() {
        assertEquals(
            RatingLevel(RatingLevel.HIGHEST).hashCode(),
            RatingLevel(RatingLevel.HIGHEST).hashCode()
        )
    }

    @Test
    fun hashCodeIsNotEqualIfLevelIsNotSame() {
        assertNotEquals(
            RatingLevel(RatingLevel.LOWEST).hashCode(),
            RatingLevel(RatingLevel.HIGHEST).hashCode()
        )
    }

}