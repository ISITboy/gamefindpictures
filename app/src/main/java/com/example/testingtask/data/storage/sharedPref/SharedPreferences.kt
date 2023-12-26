package com.example.testingtask.data.storage.sharedPref

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferences @Inject constructor(
    @ApplicationContext private val appContext: Context
) {
    operator fun invoke() = appContext.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    companion object{
        private const val SHARED_PREFS_NAME = "shared_prefs_name"
    }
}