package com.example.bocahpintar_belajaranak.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bocahpintar_belajaranak.model.UserModel
import com.example.bocahpintar_belajaranak.pref.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UserRepository): ViewModel() {
    fun saveUser(userModel: UserModel){
        viewModelScope.launch {
            repository.saveUser(userModel)
        }
    }
}