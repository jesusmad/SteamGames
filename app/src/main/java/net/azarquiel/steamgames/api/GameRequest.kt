package net.azarquiel.steamgames.api

import android.util.Log
import com.google.gson.Gson
import net.azarquiel.steamgames.models.Game
import net.azarquiel.steamgames.models.GameResponse
import net.azarquiel.steamgames.views.MainActivity
import java.net.URL

/**
 * Created by jr on 29-Jan-18.
 */
class GameRequest(var appid: Int) {

    var game = Game()

    init {
        val jsonurl = "http://store.steampowered.com/api/appdetails?appids=${appid}&cc=es&l=spanish"
        val gameinfojson = URL(jsonurl).readText(charset("UTF-8"))
        val gameinforesponse = Gson().fromJson(gameinfojson, GameResponse::class.java)
    }
}