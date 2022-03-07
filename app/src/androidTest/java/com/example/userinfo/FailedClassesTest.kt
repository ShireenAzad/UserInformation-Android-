package com.example.userinfo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ScrollToAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test


class FailedClassesTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkingDisplayOfToastMessageIfAllFieldsAreNotEntered() {
        var scenario: ActivityScenario<*> = activityRule.scenario
        onView(withId(R.id.userNameET))
            .perform(ViewActions.typeText("Shireen")).perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.validate)).perform(ScrollToAction()).perform(ViewActions.click())
        onView(allOf(withId(R.string.eachFieldToast), isDisplayed()));
    }

    @Test
    fun checkingDisplayOfToastMessageIfAtLeastOneFiledIsEmpty() {
        var scenario: ActivityScenario<*> = activityRule.scenario
        onView(withId(R.id.userNameET)).perform(ViewActions.typeText("Shireen"))
        onView(withId(R.id.emailET)).perform(ViewActions.typeText("ShireenAzad@gmail.com"))
        onView(withId(R.id.phoneNumberET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("8790103730"))
        onView(withId(R.id.pinCodeET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("516008")).perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.validate)).perform(ScrollToAction()).perform(ViewActions.click())
        onView(allOf(withId(R.string.eachFieldToast), isDisplayed()));
    }

    @Test
    fun checkingDisplayOfToastMessageIfProperEmailIdIsNotEntered() {
        var scenario: ActivityScenario<*> = activityRule.scenario
        onView(withId(R.id.userNameET)).perform(ViewActions.typeText("Shireen"))
        onView(withId(R.id.emailET)).perform(ViewActions.typeText("ShireenAzad@gmail.xom"))
        onView(withId(R.id.phoneNumberET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("8790103730"))
        onView(withId(R.id.pinCodeET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("516008"))
        onView(withId(R.id.addressET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("balaji nagar,guntur"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.validate)).perform(ScrollToAction()).perform(ViewActions.click())
        onView(allOf(withId(R.string.emailToast), isDisplayed()));
    }

    @Test
    fun checkingDisplayOfToastMessageIfValidPhoneNumberIsNotEntered() {
        var scenario: ActivityScenario<*> = activityRule.scenario
        onView(withId(R.id.userNameET)).perform(ViewActions.typeText("Shireen"))
        onView(withId(R.id.emailET)).perform(ViewActions.typeText("ShireenAzad@gmail.com"))
        onView(withId(R.id.phoneNumberET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("879003730"))
        onView(withId(R.id.pinCodeET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("516008"))
        onView(withId(R.id.addressET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("balaji nagar,guntur"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.validate)).perform(ScrollToAction()).perform(ViewActions.click())
        onView(allOf(withId(R.string.phoneNumberToast), isDisplayed()));
    }

    @Test
    fun checkingDisplayOfToastMessageIfValidPinCodeIsNotEntered() {
        var scenario: ActivityScenario<*> = activityRule.scenario
        onView(withId(R.id.userNameET)).perform(ViewActions.typeText("Shireen"))
        onView(withId(R.id.emailET)).perform(ViewActions.typeText("ShireenAzad@gmail.com"))
        onView(withId(R.id.phoneNumberET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("8790103730"))
        onView(withId(R.id.pinCodeET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("51600"))
        onView(withId(R.id.addressET)).perform(ScrollToAction())
            .perform(ViewActions.typeText("balaji nagar,guntur"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.validate)).perform(ScrollToAction()).perform(ViewActions.click())
        onView(allOf(withId(R.string.phoneNumberToast), isDisplayed()));
    }

}