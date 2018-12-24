package com.example.carlos.realprogrammersnew

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import com.example.carlos.realprogrammersnew.instrumentationtestutils.RecyclerViewMatcher.Companion.withRecyclerView
import com.example.carlos.realprogrammersnew.instrumentationtestutils.withRating
import com.example.carlos.realprogrammersnew.platform.views.ProgrammersActivity
import org.hamcrest.Matchers.closeTo
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ProgrammersEditViewTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(
        ProgrammersActivity::class.java,
        true,
        true
    )


    @Test
    fun checkCancelAddProgrammer() {

        onView(withId(R.id.fab_programmers_list))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.firstname_edit_text_programmer_edit))
            .check(matches(isDisplayed()))
            .perform(typeText("Roberto"))

        pressBack()
        pressBack()

        onView(withText("OK"))
            .perform(click())

        onView(withId(R.id.recyclerView))
            .check(matches(isDisplayed()))

    }

    @Test
    fun checkAddProgrammer() {

        onView(withId(R.id.fab_programmers_list))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.save_programmer_button))
            .check(matches(isDisplayed()))
            .check(matches(isDisplayed()))

        onView(withId(R.id.firstname_edit_text_programmer_edit))
            .check(matches(isDisplayed()))
            .perform(typeText("Roberto"))

        pressBack()

        onView(withId(R.id.save_programmer_button))
            .check(matches(isDisplayed()))
            .check(matches(isDisplayed()))

        onView(withId(R.id.lastname_edit_text_programmer_edit))
            .check(matches(isDisplayed()))
            .perform(typeText("Gomez Bolanos"))

        pressBack()

        onView(withId(R.id.save_programmer_button))
            .check(matches(isDisplayed()))
            .check(matches(isEnabled()))

        onView(withId(R.id.favorite_toggle_button_programmer_edit))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.emacs_seek_bar_programmer_edit))
            .check(matches(isDisplayed()))
            .perform(swipeLeft())

        onView(withId(R.id.caffeine_seek_bar_programmer_edit))
            .check(matches(isDisplayed()))
            .perform(swipeRight())

        onView(withId(R.id.rpr_rating_bar_programmer_edit))
            .check(matches(isDisplayed()))
            .check(matches(withRating(closeTo(2 + 1.0, 0.1))))

        pressBack()

        onView(withText("Cancel"))
            .perform(click())

        onView(withId(R.id.save_programmer_button))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.recyclerView))
            .check(matches(isDisplayed()))
            .perform(swipeUp())

        onView(withRecyclerView(R.id.recyclerView).atPosition(10))
            .check(matches(isDisplayed()))
            .check(matches(hasDescendant(withText("Roberto"))))

    }


    companion object {

        @BeforeClass
        @JvmStatic
        fun before_class_method() {
            Log.e("@Before Class", "Hi this is run before anything")
        }

        @AfterClass
        @JvmStatic
        fun after_class_method() {
            Log.e("@After Class", "Hi this is run after everything")
        }

    }

}