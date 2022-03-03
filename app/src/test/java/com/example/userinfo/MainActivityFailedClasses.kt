package com.example.userinfo

import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertEquals
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.junit.Before;
import org.junit.Test;
import org.robolectric.RuntimeEnvironment;

@RunWith(RobolectricTestRunner::class)
class MainActivityFailedClasses {
    @MockK
    lateinit var mainActivity: MainActivity

    @Before
    fun setUp() {
        mainActivity.applicationContext
    }

    @Test
    fun testIsNotificationsEnabled_Default() {
        assertEquals(true, mainActivity.emailValidation("fs"));
    }
}