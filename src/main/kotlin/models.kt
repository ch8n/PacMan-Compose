import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.*
import org.jetbrains.skija.ImageInfo
import java.lang.Math.abs

sealed class SceneEntity {
    abstract fun update(scene: Scene)
}


data class Boid(val sample:Boolean) : SceneEntity() {

    private var acceleration: Vector = vector()
    private var velocity: Vector = vectorRandom2D()
    private var position: Vector = vector()
    private var _isConfigured = false
    private var canvasWidth: Float = 0f
    private var canvasHeight: Float = 0f

    val isConfigured get() = _isConfigured

    fun setup(canvasSize: Size) = _isConfigured.onFalse {
        // use this as constructor
        val (height, width) = canvasSize
        canvasHeight = height
        canvasWidth = width
        _isConfigured = true
    }

    override fun update(scene: Scene) {
    }

    fun reset() {
        //_isConfigured = false
    }
}

