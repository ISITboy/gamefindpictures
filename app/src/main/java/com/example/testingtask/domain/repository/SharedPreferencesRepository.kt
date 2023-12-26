package com.example.testingtask.domain.repository

interface SharedPreferencesRepository {
    fun save(score:String):Boolean
    fun get():String
}