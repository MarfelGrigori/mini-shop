package com.example.onlineshopsatriaadhipradana.di

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.example.onlineshopsatriaadhipradana.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import sm.tosk.android.common.activity.ActivityScope
import sm.tosk.android.common.viewmodel.ViewModelKey

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