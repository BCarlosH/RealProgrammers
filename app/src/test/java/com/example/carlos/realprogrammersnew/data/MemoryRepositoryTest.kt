package com.example.carlos.realprogrammersnew.data

import com.example.carlos.realprogrammersnew.domain.entities.Programmer
import com.example.carlos.realprogrammersnew.domain.entities.RatingLevel
import com.example.carlos.realprogrammersnew.utils.TestData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import java.util.*


class MemoryRepositoryTest {

    private lateinit var memoryRepository: MemoryRepository
    private val programmerList = mutableListOf(TestData.createMainProgrammer(), TestData.createAltProgrammer())

    @Before
    fun setUp() {
        memoryRepository = MemoryRepository(programmers = programmerList)
    }

    @Test
    fun fetchReturnsNothingIfRepoIsEmpty() {
        val result: List<Programmer>

        memoryRepository = MemoryRepository(programmers = mutableListOf())
        result = memoryRepository.fetchProgrammers()

        assertEquals(listOf<Programmer>(), result)
    }

    @Test
    fun fetchReturnsRepoContents() {
        val result: List<Programmer>

        result = memoryRepository.fetchProgrammers()

        assertEquals(programmerList, result)
    }

    @Test
    fun createAddsProgrammerToRepo() {
        val tempList = mutableListOf(TestData.createMainProgrammer())
        memoryRepository = MemoryRepository(tempList)

        memoryRepository.addProgrammer(TestData.createAltProgrammer())

        assertEquals(2, memoryRepository.fetchProgrammers().size)
    }

    @Test
    fun getProgrammerReturnsProgrammerWithId() {
        val result: Programmer? = memoryRepository.getProgrammer(TestData.altId)

        assertEquals(TestData.createAltProgrammer(), result)
    }

    @Test
    fun getProgrammerReturnsNullWithNotExistingId() {
        val result: Programmer? = memoryRepository.getProgrammer("Not existing ID")

        assertNull(result)
    }

    @Test
    fun updateChangesEveryPropertyButId() {

        val programmerToEdit = Programmer(
            id = TestData.mainId, firstName = "Other First Name", lastName = "Other Last Name",
            emacs = 3, caffeine = 1, realProgrammerRating = RatingLevel(RatingLevel.MEDIUM),
            interviewDate = Date(), favorite = false
        )

        memoryRepository.updateProgrammer(programmerToEdit)
        val modifiedProgrammer: Programmer? = memoryRepository.fetchProgrammers()[0]

        assertEquals(programmerToEdit.id, modifiedProgrammer?.id)
        assertEquals(programmerToEdit.firstName, modifiedProgrammer?.firstName)
        assertEquals(programmerToEdit.lastName, modifiedProgrammer?.lastName)
        assertEquals(programmerToEdit.emacs, modifiedProgrammer?.emacs)
        assertEquals(programmerToEdit.caffeine, modifiedProgrammer?.caffeine)
        assertEquals(programmerToEdit.realProgrammerRating, modifiedProgrammer?.realProgrammerRating)
        assertEquals(programmerToEdit.interviewDate, modifiedProgrammer?.interviewDate)
        assertEquals(programmerToEdit.favorite, modifiedProgrammer?.favorite)
    }

}