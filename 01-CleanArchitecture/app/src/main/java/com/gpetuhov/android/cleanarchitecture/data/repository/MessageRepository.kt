package com.gpetuhov.android.cleanarchitecture.data.repository

import kotlinx.coroutines.delay

class MessageRepository {

    @Throws(Exception::class)
    suspend fun getMessage(): String {
        // Mimic server delay
        delay(5000)

        return getDummyMessage()
    }

    private fun getDummyMessage() = "Hello, world!"
}