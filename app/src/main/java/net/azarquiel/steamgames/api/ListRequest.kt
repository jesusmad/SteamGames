package net.azarquiel.steamgames.api

import com.google.gson.Gson
import net.azarquiel.steamgames.models.ListResponse
import java.net.URL

/**
 * Created by jr on 29-Jan-18.
 */
class ListRequest(jsonurl: String) {

    var appsmap = HashMap<Int, String>()

    init {

        val listjson = URL(jsonurl).readText(charset("UTF-8"))
        val listresponse = Gson().fromJson(listjson, ListResponse::class.java)
        listresponse.applist.apps.forEach { appsmap.put(it.appid, it.name) }
    }
}