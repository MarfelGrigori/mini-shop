package com.example.onlineshopsatriaadhipradana

import androidx.lifecycle.ViewModelProvider
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [
    ActivityModule::class,
])
interface ActivityComponent {
    fun getViewModelFactory(): ViewModelProvider.Factory

    @Subcomponent.Builder
    interface Builder {
        fun activityModule(module: ActivityModule): Builder
        fun build(): ActivityComponent
    }
}