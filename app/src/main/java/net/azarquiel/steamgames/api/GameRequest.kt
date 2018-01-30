package net.azarquiel.steamgames.api

import com.google.gson.Gson
import net.azarquiel.steamgames.models.Game
import net.azarquiel.steamgames.models.GameResponse
import java.net.URL
import org.json.JSONObject


/**
 * Created by jr on 29-Jan-18.
 */
class GameRequest(appid: Int) {

    var game = Game()

    init {
        val jsonurl = "http://store.steampowered.com/api/appdetails?appids=${appid}&cc=es&l=spanish"
        val gameinfojson = URL(jsonurl).readText(charset("UTF-8"))

        val jsonobj = JSONObject(gameinfojson)
        val norootjson = jsonobj.get("$appid").toString()

        val gameinforesponse = Gson().fromJson(norootjson, GameResponse::class.java)
        val data = gameinforesponse.data
        game = Game(appid, data.name, data.short_description, data.header_image, data.website)
    }
}