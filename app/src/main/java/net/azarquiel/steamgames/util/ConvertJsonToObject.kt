package net.azarquiel.steamgames.util

import com.google.gson.GsonBuilder

/**
 * Created by jr on 30-Jan-18.
 */
class ConvertJsonToObject {

    private val gson = GsonBuilder().create()

    fun <T> getFromJSON(json: String, clazz: Class<T>): T {
        return gson.fromJson(json, clazz)
    }

    fun <T> toJSON(clazz: T): String {
        return gson.toJson(clazz)
    }

}