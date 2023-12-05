package com.example.bocahpintar_belajaranak.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.bocahpintar_belajaranak.model.UserModel
import com.example.bocahpintar_belajaranak.pref.UserRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: UserRepository): ViewModel() {
    fun getUser() = repository.getUser().asLiveData()
}