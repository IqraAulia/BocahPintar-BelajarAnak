package com.example.bocahpintar_belajaranak.pref




import com.example.bocahpintar_belajaranak.model.UserModel
import retrofit2.HttpException
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File



class UserRepository private constructor(
    private val userPreference: UserPreference
) {

    suspend fun saveUser(user: UserModel) {
        userPreference.saveUser(user)
    }

    fun getUser(): Flow<UserModel> {
        return userPreference.getUser()
    }

    companion object {
        fun getInstance (
            userPreference: UserPreference
        ):UserRepository = UserRepository(userPreference)
//        @Volatile
//        private var instance: UserRepository? = null
//        fun getInstance(
//
//            userPreference: UserPreference
//        ): UserRepository = instance ?: synchronized(this) {
//            instance ?: UserRepository(userPreference)
//        }.also { instance = it }
    }
}
