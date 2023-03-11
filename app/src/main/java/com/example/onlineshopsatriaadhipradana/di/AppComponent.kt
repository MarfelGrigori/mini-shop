package com.example.onlineshopsatriaadhipradana.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ViewModelModule::class,
        AppModule::class,
        DatabaseModule::class,
        ActivityBuilderModule::class
    ]
)

interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun provideApplication(app: Application): Builder

        fun build(): AppComponent
    }
}