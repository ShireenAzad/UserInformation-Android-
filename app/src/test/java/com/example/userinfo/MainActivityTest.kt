package com.example.userinfo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class MainActivityTest {

    @MockK
    private lateinit var mainActivity: MainActivity
    @MockK
    private lateinit var validations:Validations

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {

        mainActivity = MainActivity()
        validations = Validations()

    }


    @Test
    fun isEmailValid() {

        assertTrue(validations.emailValidation(mainActivity,"shireen@gmail.com"))
    }

    @Test
    fun isPhoneNumberValid() {
        assertTrue(validations.phoneNumberValidation(mainActivity,"8790103730"))
    }

    @Test
    fun isPinCodeValid() {
        assertTrue(validations.pinCodeValidation(mainActivity,"516004"))
    }
    @Test
    fun isAllFieldsEntered() {
        assertTrue(
            validations.fieldsValidationToCheckAllFieldsAreEntered(mainActivity,
                "Banu",
                "banu@gmail.com",
                "8790103730",
                "516004",
                "1/1534-1,yerramukka palli,kadapa"
            )
        )
    }


}
