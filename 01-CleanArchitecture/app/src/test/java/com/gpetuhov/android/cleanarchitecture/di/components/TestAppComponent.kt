package com.gpetuhov.android.cleanarchitecture.di.components

import com.gpetuhov.android.cleanarchitecture.di.modules.TestAppModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [TestAppModule::class])
@Singleton
interface TestAppComponent : AppComponent {
    // TODO: inject
}