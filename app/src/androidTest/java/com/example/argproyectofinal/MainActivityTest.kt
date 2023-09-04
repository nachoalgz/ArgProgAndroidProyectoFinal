package com.example.argproyectofinal

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)


    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun resultMainActivityCheck(){
        Espresso.onView(
            ViewMatchers.withId(R.id.cmpBtn)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId((R.id.TextViewResult))
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Son Iguales")
            )
        )
    }
}