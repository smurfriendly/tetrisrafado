package ipca.tetris.projetocm

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var storage: FirebaseStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        storage = Firebase.storage
        var storageRef = storage.reference

        val ImageView = findViewById<ImageView>(R.id.logo)

        val buttonPlay = findViewById<ImageButton>(R.id.buttonPlay)
        buttonPlay.setOnClickListener {
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            startActivity(intent)

        }

        val buttonQuit = findViewById<ImageButton>(R.id.buttonQuit)
        buttonQuit.setOnClickListener{
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            exitProcess(0)
        }

        val buttonLeaderboard = findViewById<ImageButton>(R.id.buttonLeaderboard)
        buttonLeaderboard.setOnClickListener {
            val intent = Intent(this@MainActivity, LeaderboardActivity::class.java)
            startActivity(intent)
        }

        val buttonSettings = findViewById<ImageButton>(R.id.buttonSettings)
        buttonSettings.setOnClickListener {
            val intent = Intent(this@MainActivity, SettingsActivity::class.java)
            startActivity(intent)
        }

        val buttonStats = findViewById<ImageButton>(R.id.buttonStats)
        buttonStats.setOnClickListener {
            val intent = Intent(this@MainActivity, StatsActivity::class.java)
            startActivity(intent)
        }

        val buttonSkins = findViewById<ImageButton>(R.id.buttonSkins)
        buttonSkins.setOnClickListener {
            val intent = Intent(this@MainActivity, SkinsActivity::class.java)
            startActivity(intent)
        }
    }
}