package com.example.stroryapp.di

import android.content.Context
import com.example.bocahpintar_belajaranak.pref.UserPreference
import com.example.bocahpintar_belajaranak.pref.UserRepository
import com.example.bocahpintar_belajaranak.pref.dataStore




object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(pref)
    }
}