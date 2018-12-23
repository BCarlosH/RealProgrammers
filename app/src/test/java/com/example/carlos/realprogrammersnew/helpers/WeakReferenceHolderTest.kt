package com.example.carlos.realprogrammersnew.helpers

import org.junit.Assert.assertNull
import org.junit.Assert.assertSame
import org.junit.Before
import org.junit.Test

class WeakReferenceHolderTest {
    class TestClass

    private var testClass: TestClass? by WeakReferenceHolder()
    private var strongRef: TestClass? = null


    @Before
    fun setUp() {
        strongRef = TestClass()
    }

    @Test
    fun initialReferenceIsNull() {
        assertNull(testClass)
    }

    @Test
    fun valueIsStrongReferenceWhenSet() {
        testClass = strongRef
        assertSame(strongRef, testClass)
    }

    @Test
    fun valueIsNullWhenUnset() {
        testClass = strongRef
        testClass = null
        assertNull(testClass)
    }

    @Test
    fun valueIsNullWhenStrongReferenceIsReleased() {
        testClass = strongRef
        strongRef = null
        Runtime.getRuntime().gc()
        assertNull(testClass)
    }

}