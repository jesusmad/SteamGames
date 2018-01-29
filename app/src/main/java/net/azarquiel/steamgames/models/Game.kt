package net.azarquiel.steamgames.models

/**
 * Created by jr on 29-Jan-18.
 */
data class Game(
        var id: Int = -1,
        var name: String = "",
        var description: String = "",
        var image: String = "",
        var link: String = "")