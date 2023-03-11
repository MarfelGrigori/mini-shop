package com.example.onlineshopsatriaadhipradana.di

import com.example.onlineshopsatriaadhipradana.SigninFragment
import com.example.onlineshopsatriaadhipradana.WelocomeBackFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBuilderModule {

    @ContributesAndroidInjector
    @FragmentScoped
    abstract fun contributeBlankFragment(): SigninFragment

    @ContributesAndroidInjector
    @FragmentScoped
    abstract fun contributeSecondFragment(): WelocomeBackFragment

}