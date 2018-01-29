package net.azarquiel.steamgames.models

/**
 * Created by jr on 29-Jan-18.
 */
data class ListResponse(var applist: AppList)
data class AppList(var apps: List<Apps>)
data class Apps(var appid: Int, var name: String)

