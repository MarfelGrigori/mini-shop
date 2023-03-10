package com.example.onlineshopsatriaadhipradana.localdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items_table")
data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val image: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}