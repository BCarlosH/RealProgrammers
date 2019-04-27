package com.example.carlos.realprogrammers

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.swipeUp
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import com.example.carlos.realprogrammers.instrumentationtestutils.RecyclerViewMatcher.Companion.withRecyclerView
import com.example.carlos.realprogrammers.instrumentationtestutils.withViewAtPosition
import com.example.carlos.realprogrammers.platform.views.ProgrammersActivity
import org.hamcrest.Matchers.allOf
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ProgrammersListViewTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(
        ProgrammersActivity::class.java,
        true,
        true
    )


    @Test
    fun checkList() {

        onView(withId(R.id.recyclerView))
            .check(matches(isDisplayed()))

        onView(withRecyclerView(R.id.recyclerView).atPosition(0))
            .check(matches(isDisplayed()))
            .check(matches(hasDescendant(withText("Pepe"))))

        onView(withId(R.id.recyclerView))
            .check(
                matches(
                    withViewAtPosition(
                        0,
                        hasDescendant(allOf(withId(R.id.item_programmer_favorite_toggle_button), isDisplayed()))
                    )
                )
            )

        onView(withId(R.id.recyclerView))
            .check(matches(isDisplayed()))
            .perform(swipeUp())

        onView(withRecyclerView(R.id.recyclerView).atPosition(9))
            .check(matches(isDisplayed()))
            .check(matches(hasDescendant(withText("Joaquin"))))

    }


    companion object {

        @BeforeClass
        @JvmStatic
        fun before_class_method() {
            Log.e("@Before Class", "Run before anything")
        }

        @AfterClass
        @JvmStatic
        fun after_class_method() {
            Log.e("@After Class", "Run after everything")
        }

    }

}