package com.max.kkbox.data


sealed class MaxResult<out R> {

    data class Success<out T>(val data: T) : MaxResult<T>()
    data class Fail(val error: String?) : MaxResult<Nothing>()
    data class Error(val exception: Exception) : MaxResult<Nothing>()
    object Loading : MaxResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[result=$data]"
            is Fail -> "Fail[error=$error]"
            is Error -> "Error[exception=${exception.message}]"
            Loading -> "Loading"
        }
    }
}


val MaxResult<*>.succeeded
    get() = this is MaxResult.Success && data != null
