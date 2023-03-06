package com.example.onlineshopsatriaadhipradana

import androidx.lifecycle.*
import com.example.onlineshopsatriaadhipradana.CommonViewModelFactory
import dagger.*
import javax.inject.Provider

@Module
class ViewModelModule {
    @Provides
    fun provideViewModelFactory(
        viewModelProviders: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
    ): ViewModelProvider.Factory = CommonViewModelFactory(viewModelProviders)
}