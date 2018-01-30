package net.azarquiel.steamgames.models

import com.google.gson.annotations.SerializedName

/**
 * Created by jr on 29-Jan-18.
 */
//List
data class ListResponse(var applist: AppList)
data class AppList(var apps: List<Apps>)
data class Apps(var appid: Int, var name: String)

//AppDetail
data class GameResponse(var data: Data)
data class Data(
        var name: String,
        var short_description: String,
        var header_image: String,
        var website: String)


