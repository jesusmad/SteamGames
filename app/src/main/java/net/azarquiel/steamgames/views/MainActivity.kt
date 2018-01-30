package net.azarquiel.steamgames.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.azarquiel.steamgames.R
import net.azarquiel.steamgames.api.GameRequest
import net.azarquiel.steamgames.api.ListRequest
import net.azarquiel.steamgames.models.Game
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "****JR****"
        val LISTJSON = "http://api.steampowered.com/ISteamApps/GetAppList/v0002/"
    }

    private var gamesmap = HashMap<Int, String>()
    private var game = Game()
    private var id = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getGameList()

        btnSearch.setOnClickListener { v -> searchClicked() }
    }

    private fun searchClicked() {
        val inputtxt = etSearch.text.toString()
        gamesmap.forEach { if (it.value.toLowerCase().equals(inputtxt.toLowerCase()))  id = it.key }

        if (id != -1)
            getGame(id)
        else
            longToast("The game $inputtxt doesn't exist")

    }

    fun getGameList(){
        val progress = indeterminateProgressDialog("Loading game list...")
        progress.show()
        doAsync {
            val listrequest = ListRequest(LISTJSON)
            gamesmap = listrequest.appsmap
            uiThread {
                progress.hide()
            }
        }
    }

    fun getGame(appid: Int) {
        doAsync {
            val gamerequest = GameRequest(appid)
            game = gamerequest.game
            uiThread {
                Log.d(TAG, "${game.name} - ${game.description}")
                longToast("${game.name} - ${game.link}")
            }
        }
    }

}
