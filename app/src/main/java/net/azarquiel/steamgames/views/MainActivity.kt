package net.azarquiel.steamgames.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import net.azarquiel.steamgames.R
import net.azarquiel.steamgames.api.GameRequest
import net.azarquiel.steamgames.api.ListRequest
import net.azarquiel.steamgames.models.Game
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "****JR****"
    }

    private lateinit var appsmap : HashMap<Int, String>
    private var game = Game()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progress = indeterminateProgressDialog("Loading game list...")
        progress.show()
        doAsync {
            val listrequest = ListRequest("http://api.steampowered.com/ISteamApps/GetAppList/v0002/")
            appsmap = listrequest.appsmap

            uiThread {
                progress.hide()
            }
        }

        doAsync {
            val gamerequest = GameRequest(57690)
            game = gamerequest.game
            uiThread {
                Log.d(TAG, "Game: ${game.name} - Description: ${game.description}")
            }
        }


    }
}
