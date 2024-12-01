package com.example.datastoreandarchitecture.core

sealed interface OperationStatus<SuccessType> {
    data class Success<SuccessType>(val value: SuccessType) : OperationStatus<SuccessType>
    data class Failure<SuccessType>(val exception: Exception) : OperationStatus<SuccessType>
}