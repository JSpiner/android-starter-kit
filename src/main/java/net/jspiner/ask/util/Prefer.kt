package net.jspiner.ask.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson


@SuppressLint("StaticFieldLeak")
object Prefer {

    private lateinit var preferences: SharedPreferences
    private lateinit var fileName: String

    private lateinit var context: Context

    val sharedPreferences: SharedPreferences?
        @Synchronized get() {
            if (::preferences.isInitialized) {
                preferences = context!!.getSharedPreferences(fileName, Context.MODE_PRIVATE)
            }
            return preferences
        }

    fun init(context: Context) {
        Prefer.context = context
        Prefer.fileName = context.getPackageName()
    }

    fun set(key: String, value: Any) {
        val editor = sharedPreferences!!.edit()

        when (value) {
            is Int -> editor.putInt(key, value)
            is String -> editor.putString(key, value as String?)
            is Boolean -> editor.putBoolean(key, (value as Boolean?)!!)
            is Float -> editor.putFloat(key, (value as Float?)!!)
            is Long -> editor.putLong(key, (value as Long?)!!)
            else -> editor.putString(key, Gson().toJson(value))
        }

        editor.apply()
    }

    fun <T> get(key: String, defaultValue: T): T {
        val preference = sharedPreferences

        val returnValue: Any
        returnValue = when (defaultValue) {
            is Int -> preference!!.getInt(key, (defaultValue as Int).toInt())
            is String -> preference!!.getString(key, defaultValue as String)
            is Boolean -> preference!!.getBoolean(key, defaultValue as Boolean)
            is Float -> preference!!.getFloat(key, defaultValue as Float)
            is Long -> preference!!.getLong(key, defaultValue as Long)
            else -> preference!!.getString(key, defaultValue as String)
        }

        return returnValue as T
    }

}