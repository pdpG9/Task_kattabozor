package com.example.task_kattabozor.utils

interface Event<T> {
    fun onSuccess(data:T)
    fun onFailed(e:Exception)
    fun onMessage(message:String)
}