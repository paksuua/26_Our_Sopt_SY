package com.example.soptseminar1weeks

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(context: Context) {

    val PREFS_FILENAME = "prefs"
    val PREF_KEY_ID = "id"
    val PREF_KEY_PWD = "pwd"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    var id: String?
        get() = prefs.getString(PREF_KEY_ID, "")
        set(value) = prefs.edit().putString(PREF_KEY_ID, value).apply()

    var pwd: String?
        get() = prefs.getString(PREF_KEY_PWD, "")
        set(value) = prefs.edit().putString(PREF_KEY_PWD, value).apply()

}