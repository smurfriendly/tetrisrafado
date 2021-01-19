package ipca.tetris.projetocm


import android.graphics.Rect
import androidx.constraintlayout.solver.widgets.Rectangle
import java.util.*

    public class Form {

        var x = 0
        var y = 0
        var speed = 0
        var maxY = 0
        var minY = 0
        var maxX = 0
        var minX = 0
        var isGoingDown = true
        public var stopped=false
        lateinit var detectCollision : Rect

        constructor(width: Int, height: Int) {
            maxX = width
            minX = 0
            maxY = height
            minY = 0
            detectCollision = Rect(x,y,x+200,y+200)

            x = maxX/2
            y = 0
        }

        fun update(){
            if(isGoingDown) {
                y += 5

                if (y >= maxY-375) {
                    y = maxY-375
                    isGoingDown=false
                }

            }
            detectCollision.left = x
            detectCollision.top = y
            detectCollision.right = x +200
            detectCollision.bottom = y +200
        }
    }