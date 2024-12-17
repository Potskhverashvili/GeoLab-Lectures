package com.example.coctailsapplication.core

import retrofit2.Response


inline fun <T> safeApiCall(call: () -> Response<T>): Result<T> {
    return try {
        val response = call()
        if (response.isSuccessful) {
            Result.success(response.body()!!)
        } else {
            Result.failure(Exception(response.errorBody()?.toString() ?: "Unknown error"))
        }
    } catch (e: Exception) {
        Result.failure(e)
    }
}
