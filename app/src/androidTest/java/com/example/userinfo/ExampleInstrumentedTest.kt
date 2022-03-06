package com.example.userinfo

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ScrollToAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.not

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.userinfo", appContext.packageName)
    }

    @Test
    fun validatingData() {
        onView(withId(R.id.userNameET)).perform(ViewActions.typeText("Shireen"))
        onView(withId(R.id.emailET)).perform(ViewActions.typeText("ShireenAzad@gmail.com"))
        onView(withId(R.id.phoneNumberET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("8790103730"))
        onView(withId(R.id.pinCodeET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("516008"))
        onView(withId(R.id.addressET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("balaji nagar,guntur"))
        onView(withId(R.id.validate)).perform(ScrollToAction()).perform(ViewActions.click())
        onView(withId(R.id.validUserName)).check(ViewAssertions.matches(ViewMatchers.withText("Shireen")))
        onView(withId(R.id.validEmail)).check(ViewAssertions.matches(ViewMatchers.withText("ShireenAzad@gmail.com")))
        onView(withId(R.id.validPhoneNumber)).check(ViewAssertions.matches(ViewMatchers.withText("8790103730")))
        onView(withId(R.id.validPinCode)).check(ViewAssertions.matches(ViewMatchers.withText("516008")))
        onView(withId(R.id.validAddress)).check(ViewAssertions.matches(ViewMatchers.withText("balaji nagar,guntur")))

    }

    @Test
    fun validateData() {
        onView(withId(R.id.userNameET)).perform(ViewActions.typeText("Shireen"))
        onView(withId(R.id.emailET)).perform(ViewActions.typeText("ShireenAzad@gmail.com"))
        onView(withId(R.id.phoneNumberET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("8790103730"))
        onView(withId(R.id.pinCodeET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("516008"))
        onView(withId(R.id.addressET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("balaji nagar,guntur"))
        onView(withId(R.id.validate)).perform(ScrollToAction()).perform(ViewActions.click())
        onView(withId(R.id.validUserName)).check(ViewAssertions.matches(ViewMatchers.withText("Shireen")))
        onView(withId(R.id.validEmail)).check(ViewAssertions.matches(ViewMatchers.withText("ShireenAzad@gmail.com")))
        onView(withId(R.id.validPhoneNumber)).check(ViewAssertions.matches(ViewMatchers.withText("8790103730")))
        onView(withId(R.id.validPinCode)).check(ViewAssertions.matches(ViewMatchers.withText("516008")))
        onView(withId(R.id.validAddress)).check(ViewAssertions.matches(ViewMatchers.withText("balaji nagar,guntur")))
        onView(withId(R.id.confirm)).perform(ViewActions.click())
        onView(withId(R.id.userDetails)).check(ViewAssertions.matches(withText("Hi Shireen,How are you? Are you staying at balaji nagar,guntur 516008. I am not able to contact you on 8790103730. Can I email you the details at ShireenAzad@gmail.com")))

    }
}