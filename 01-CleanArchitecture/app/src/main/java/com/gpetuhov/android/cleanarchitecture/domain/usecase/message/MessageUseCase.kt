package com.gpetuhov.android.cleanarchitecture.domain.usecase.message

import com.gpetuhov.android.cleanarchitecture.data.repository.MessageRepository

class MessageUseCase(private val messageRepository: MessageRepository) {

    @Throws(InputValidationException::class)
    suspend fun getMessage(onGetMessageStarted: suspend () -> Unit): String {
        // In case of some input validation error throw exception
        // (in our example this never happens, because there is no input)
        if (false) throw InputValidationException()

        onGetMessageStarted()
        return messageRepository.getMessage()
    }
}