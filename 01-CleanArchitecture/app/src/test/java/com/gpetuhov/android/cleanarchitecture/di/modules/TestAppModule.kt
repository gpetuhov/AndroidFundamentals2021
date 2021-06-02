package com.gpetuhov.android.cleanarchitecture.di.modules

import com.gpetuhov.android.cleanarchitecture.data.repository.MessageRepository
import com.gpetuhov.android.cleanarchitecture.domain.usecase.message.MessageUseCase
import dagger.Module
import dagger.Provides
import org.mockito.Mockito
import javax.inject.Singleton

@Module
class TestAppModule {

    @Provides
    @Singleton
    fun providesMessageRepository(): MessageRepository =
        Mockito.mock(MessageRepository::class.java)

    @Provides
    @Singleton
    fun providesMessageUseCase(messageRepository: MessageRepository) =
        MessageUseCase(messageRepository)
}