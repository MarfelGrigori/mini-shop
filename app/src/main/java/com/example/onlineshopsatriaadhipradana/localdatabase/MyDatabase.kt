package com.example.onlineshopsatriaadhipradana.localdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun itemDAO(): ItemDAO

    companion object {
        private var INSTANCE: MyDatabase? = null

        fun getINSTANCE(context: Context): MyDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, MyDatabase::class.java, "database").build()
            }
            return INSTANCE as MyDatabase
        }
    }

}