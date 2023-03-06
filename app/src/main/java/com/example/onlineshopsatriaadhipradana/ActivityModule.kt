package com.example.onlineshopsatriaadhipradana

import android.app.Activity
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [

])
class ActivityModule(private val activity: Activity) {
    @ActivityScope
    @Provides
    fun provideActivity(): Activity = activity

    @ActivityScope
    @Provides
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun provideMainViewModel(
    ): ViewModel =
       HomeViewModel(

        )
}