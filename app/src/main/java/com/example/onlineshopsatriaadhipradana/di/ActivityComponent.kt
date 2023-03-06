package com.example.onlineshopsatriaadhipradana.di

import androidx.lifecycle.ViewModelProvider
import dagger.Subcomponent
import sm.tosk.android.common.activity.ActivityScope
import sm.tosk.android.common.viewmodel.ViewModelModule


@ActivityScope
@Subcomponent(modules = [
    ActivityModule::class,
    ViewModelModule::class,
])
interface ActivityComponent {
    fun getViewModelFactory(): ViewModelProvider.Factory

    @Subcomponent.Builder
    interface Builder {
        fun activityModule(module: ActivityModule): Builder
        fun build(): ActivityComponent
    }
}