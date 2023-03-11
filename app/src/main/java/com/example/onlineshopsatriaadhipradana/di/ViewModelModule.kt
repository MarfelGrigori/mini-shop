package com.example.onlineshopsatriaadhipradana.di

import androidx.lifecycle.ViewModel
import com.example.onlineshopsatriaadhipradana.localdatabase.MyViewModel
import com.example.onlineshopsatriaadhipradana.localdatabase.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap


@Module
 class ViewModelModule {

    @Provides
    @IntoMap
    @ViewModelKey(MyViewModel::class)
     fun bindMainViewModel(repository: UsersRepository): ViewModel = MyViewModel(repository)
}