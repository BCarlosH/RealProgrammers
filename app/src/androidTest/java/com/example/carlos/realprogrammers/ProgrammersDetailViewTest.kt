package com.example.carlos.realprogrammers

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import com.example.carlos.realprogrammers.instrumentationtestutils.RecyclerViewMatcher.Companion.withRecyclerView
import com.example.carlos.realprogrammers.instrumentationtestutils.withRating
import com.example.carlos.realprogrammers.instrumentationtestutils.withViewAtPosition
import com.example.carlos.realprogrammers.platform.views.ProgrammersActivity
import org.hamcrest.Matchers
import org.hamcrest.Matchers.closeTo
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ProgrammersDetailViewTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(
        ProgrammersActivity::class.java,
        true,
        true
    )


    @Test
    fun checkDetail() {

        onView(withRecyclerView(R.id.recyclerView).atPosition(1))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.first_name_text_view_programmer_detail))
            .check(matches(isDisplayed()))
            .check(matches(withText("Eugenio")))

        onView(withId(R.id.last_name_text_view_programmer_detail))
            .check(matches(isDisplayed()))
            .check(matches(withText("Jofra")))

        onView(withId(R.id.favorite_toggle_button_programmer_detail))
            .check(matches(isDisplayed()))
            .check(matches(isNotChecked()))

        onView(withId(R.id.emacs_text_view_programmer_detail))
            .check(matches(isDisplayed()))
            .check(matches(withText("Tutorial done")))

        onView(withId(R.id.caffeine_text_view_programmer_detail))
            .check(matches(isDisplayed()))
            .check(matches(withText("A coffee in the morning")))

        onView(withId(R.id.rpr_rating_bar_programmer_detail))
            .check(matches(isDisplayed()))
            .check(matches(withRating(closeTo(1 + 1.0, 0.1))))

        pressBack()

    }

    @Test
    fun checkFavourite() {

        onView(withRecyclerView(R.id.recyclerView).atPosition(2))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.favorite_toggle_button_programmer_detail))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.favorite_toggle_button_programmer_detail))
            .check(matches(isDisplayed()))
            .check(matches(isChecked()))

        pressBack()

        onView(withId(R.id.recyclerView))
            .check(
                matches(
                    withViewAtPosition(
                        2,
                        hasDescendant(
                            Matchers.allOf(
                                withId(R.id.item_programmer_favorite_toggle_button), isDisplayed()
                            )
                        )
                    )
                )
            )

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