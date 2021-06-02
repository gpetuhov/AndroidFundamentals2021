package com.gpetuhov.android.cleanarchitecture.message

import com.gpetuhov.android.cleanarchitecture.di.components.DaggerTestAppComponent
import com.gpetuhov.android.cleanarchitecture.domain.usecase.message.InputValidationException
import com.gpetuhov.android.cleanarchitecture.domain.usecase.message.MessageUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

class MessageUseCaseTest {

    @Inject lateinit var messageUseCase: MessageUseCase

    @Before
    fun init() {
        val appComponent = DaggerTestAppComponent.builder().build()
        appComponent.inject(this)
    }

    @Test(expected = InputValidationException::class)
    fun getMessage_invalidInput_throwsException() {
        messageUseCase.isInputValid = false

        runBlocking {
            messageUseCase.getMessage { /* Do nothing */ }
        }
    }

    @Test
    fun getMessage_validInput_getMessageStarted() {
        messageUseCase.isInputValid = true

        runBlocking {
            var isGetMessageStarted = false
            messageUseCase.getMessage { isGetMessageStarted = true }
            assertTrue(isGetMessageStarted)
        }
    }
}