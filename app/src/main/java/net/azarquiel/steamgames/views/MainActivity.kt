package net.azarquiel.steamgames.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import net.azarquiel.steamgames.R
import net.azarquiel.steamgames.api.ListRequest
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "****JR****"
    }

    private lateinit var appsmap : HashMap<Int, String>

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
                appsmap.forEach { if (it.value.equals("Tropico 4")) Log.d(TAG, "AppID: ${it.key} - AppName: ${it.value}")}
                Log.d(TAG, "Number of Apps: ${appsmap.count()}")
            }
        }


    }
}
