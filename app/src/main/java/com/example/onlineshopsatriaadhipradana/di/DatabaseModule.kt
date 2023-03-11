package com.example.onlineshopsatriaadhipradana.di

import android.content.Context
import androidx.room.Room
import com.example.onlineshopsatriaadhipradana.localdatabase.MyDatabase
import com.example.onlineshopsatriaadhipradana.localdatabase.UsersRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MyDatabase = Room.databaseBuilder(context, MyDatabase::class.java, "MyDatabese").build()

    @Provides
    fun provideRepository(database: MyDatabase): UsersRepository = UsersRepository(database)
}