package com.sam.tugas4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val _userList = MutableStateFlow<List<User>>(emptyList())
    val userList: StateFlow<List<User>> = _userList

    private val _selectedUser = MutableStateFlow<User?>(null)
    val selectedUser: StateFlow<User?> = _selectedUser

    init {
        viewModelScope.launch {
            _userList.value = ApiClient.apiService.getUsers()
        }
    }

    fun loadUserDetail(id: Int) {
        viewModelScope.launch {
            _selectedUser.value = ApiClient.apiService.getUser(id)
        }
    }
}