package com.example.userinfo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.robolectric.RuntimeEnvironment


@RunWith(JUnit4::class)
class MainActivityTest {

    @MockK
    private lateinit var mainActivity: MainActivity

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {

        mainActivity = MainActivity()

    }


    @Test
    fun isEmailValid() {
        assertTrue(mainActivity.emailValidation("shireen@gmail.com"))
    }

    @Test
    fun isPhoneNumberValid() {
        assertTrue(mainActivity.phoneNumberValidation("8790103730"))
    }

    @Test
    fun isPinCodeValid() {
        assertTrue(mainActivity.pinCodeValidation("516004"))
    }
    @Test
    fun isPinCodeInValid() {
        println(mainActivity.pinCodeValidation("51600"))
        assertTrue(mainActivity.pinCodeValidation("51600"))
    }

    @Test
    fun isAllFieldsEntered() {
        assertTrue(
            mainActivity.fieldsValidationToCheckAllFieldsAreEntered(
                "Banu",
                "banu@gmail.com",
                "8790103730",
                "516004",
                "1/1534-1,yerramukka palli,kadapa"
            )
        )
    }


}
