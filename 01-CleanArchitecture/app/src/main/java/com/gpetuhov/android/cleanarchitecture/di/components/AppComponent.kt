package com.gpetuhov.android.cleanarchitecture.di.components

import com.gpetuhov.android.cleanarchitecture.di.modules.AppModule
import com.gpetuhov.android.cleanarchitecture.presentation.welcome.WelcomeViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(welcomeViewModel: WelcomeViewModel)
}