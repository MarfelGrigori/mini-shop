package com.example.onlineshopsatriaadhipradana.di

import dagger.Component
import sm.tosk.android.common.activity.ActivityComponentBuilderModule
import sm.tosk.android.common.application.ApplicationModule


@Component(modules = [
    ApplicationModule::class,
    ActivityComponentBuilderModule::class,

])
interface ApplicationComponent {
    fun getActivityComponentBuilder(): ActivityComponent.Builder

    @Component.Builder
    interface Builder {
        fun addApplicationModule(module: ApplicationModule): Builder
        fun build(): ApplicationComponent
    }
}