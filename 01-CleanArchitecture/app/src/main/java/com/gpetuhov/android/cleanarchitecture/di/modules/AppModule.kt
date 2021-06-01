package com.gpetuhov.android.cleanarchitecture.di.modules

import android.content.Context
import com.gpetuhov.android.cleanarchitecture.App
import com.gpetuhov.android.cleanarchitecture.data.repository.MessageRepository
import com.gpetuhov.android.cleanarchitecture.data.source.local.AppPrefs
import com.gpetuhov.android.cleanarchitecture.domain.usecase.message.MessageUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun providesContext(): Context = App.application.applicationContext

    @Provides
    @Singleton
    fun providesAppPrefs(context: Context) = AppPrefs(context)

    @Provides
    @Singleton
    fun providesMessageRepository() = MessageRepository()

    @Provides
    @Singleton
    fun providesMessageUseCase(messageRepository: MessageRepository) =
        MessageUseCase(messageRepository)
}