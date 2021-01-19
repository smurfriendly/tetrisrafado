package ipca.tetris.projetocm

import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LeaderboardActivity : AppCompatActivity() {

    var leaderView : LeaderboardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        leaderView = LeaderboardView(this,size.x,size.y)
        setContentView(leaderView)
    }

    override fun onPause(){
        super.onPause()
        leaderView?.pause()
    }

    override fun onResume(){
        super.onResume()
        leaderView?.resume()
    }
}