package com.example.onlineshopsatriaadhipradana.di

import com.example.onlineshopsatriaadhipradana.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module

abstract class ActivityBuilderModule {


    @ActivityScoped
    @ContributesAndroidInjector(
        modules =
        [
            FragmentBuilderModule::class,
            ViewModelBuilder::class
        ]


    )
    abstract fun contributeMainActivity(): MainActivity


}