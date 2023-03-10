package com.example.onlineshopsatriaadhipradana.localdatabase

import androidx.room.*

@Dao
interface ItemDAO {

    @Insert
    suspend fun insert(item: User)

    @Delete
    suspend fun delete(item: User)

    @Update
    suspend fun update(item: User)

    @Query("SELECT * FROM items_table")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM items_table WHERE firstName LIKE  :user LIMIT 1")
    suspend fun fiendItem(user: String): List<User>

    @Query("SELECT * FROM items_table WHERE id = :id")
    suspend fun getItemById(id: Int): List<User>

}