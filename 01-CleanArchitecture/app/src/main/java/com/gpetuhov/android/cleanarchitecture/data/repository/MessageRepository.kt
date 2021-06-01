package com.gpetuhov.android.cleanarchitecture.data.repository

import com.gpetuhov.android.cleanarchitecture.domain.models.message.Message
import kotlinx.coroutines.delay

class MessageRepository {

    @Throws(Exception::class)
    suspend fun getMessage(): Message {
        // Mimic server delay
        delay(5000)

        return getDummyMessage()
    }

    private fun getDummyMessage() = Message("Hello, world!")
}