package ipca.tetris.projetocm

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.annotation.RequiresApi
import android.graphics.Rect

class GameActivity : SurfaceView,Runnable  {

    var surfaceHolder : SurfaceHolder? = null
    var playing = true
    var canvas : Canvas? = null
    var paint : Paint = Paint()
    var forms = arrayListOf<Form>()
    var score = 0
    var gameThread : Thread? = null

    private fun init(context : Context?, width:Int, height:Int)
    {
        surfaceHolder = holder
        forms.add(Form(width,height))
    }

    constructor(context: Context?, width: Int, height: Int):super(context)
    {
        init(context,width,height)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        init(context,0,0)
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        init(context,0,0)
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes){
        init(context,0,0)
    }

    override fun run() {
        while (playing){
            update()
            draw()
            control()
        }
    }

    private fun draw(){
        surfaceHolder?.let {
            if (it.surface.isValid){
                canvas = surfaceHolder?.lockCanvas()
                canvas?.drawColor(Color.BLACK)
                paint.textSize = 60f
                canvas?.drawText("Score :${score}", 0f, 80f, paint)
                paint.color = Color.WHITE

                for (f in forms){
                    canvas?.drawRect(f.x.toFloat(), f.y.toFloat(), f.x.toFloat() + 200f, f.y.toFloat() + 200f, paint)
                }
                surfaceHolder?.unlockCanvasAndPost(canvas)
            }
        }
    }
    fun pause(){
        playing = false
        gameThread?.join()
    }

    fun resume(){
        playing = true
        gameThread = Thread(this)
        gameThread!!.start()
    }
    private fun control(){
        Thread.sleep(17L)
    }
    private fun update(){
        for (f in forms) {
            f.update()
            if (forms.last() != f) {
                if (Rect.intersects(forms.last().detectCollision, f.detectCollision)) {
                    f.isGoingDown = false
                    score += 30
                }
            }
        }
        if(!forms.last().isGoingDown)
        {
            forms.add(Form(width,height))
        }

    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action){
            MotionEvent.ACTION_UP ->{

            }
            MotionEvent.ACTION_DOWN ->{
                forms.last().y+=50
                forms.last().x=event.x.toInt()
            }
        }
        return true
    }
}