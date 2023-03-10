package com.example.onlineshopsatriaadhipradana.localdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

class MyViewModel(application: Application) : AndroidViewModel(application) {

    private val myRepository = UsersRepository(MyDatabase.getINSTANCE(application))

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _errorBus = MutableSingleEventFlow<String>()
    val errorBus: SharedFlow<String> = _errorBus

    private val _navigate = MutableSingleEventFlow<String>()
    val nVUGte: SharedFlow<String> = _navigate

    fun insert(item: User) {
       myRepository.insert(item)
    }

    fun update(item: User) {
        myRepository.update(item)
    }

    fun getAll() {
        myRepository.loadAll { _users.tryEmit(it) }
    }

    fun fiendItem(string: String) {
        myRepository.fiendItem(string) { _users.tryEmit(it) }
    }

    fun fiendItemById(id: Int) {
        myRepository.fiendById(id) { _users.tryEmit(it) }
    }

    fun<T>MutableSingleEventFlow() = MutableSharedFlow<T>(replay = 1,extraBufferCapacity = 0,onBufferOverflow = BufferOverflow.DROP_OLDEST)

}