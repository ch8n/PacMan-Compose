import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun main() {
    Preview {
        val scene = remember { Scene() }
        scene.setupScene()
        val frameState = StepFrame {
            scene.update()
        }
        scene.render(frameState)
    }
}

class Scene {

    var sceneEntity = mutableStateListOf<SceneEntity>()

    fun setupScene() {
        sceneEntity.clear()
        //sceneEntity.addAll()
    }


    fun update() {
        for (entity in sceneEntity) {
            entity.update(this)
        }
    }

    @Composable
    fun render(frameState: State<Long>) {

        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
        ) {
            Box {

                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Black)
                        .onKeyEvent {

                            true
                        },
                ) {
                    val step = frameState.value


                }

            }


        }


    }
}



@Composable
fun StepFrame(callback: () -> Unit): State<Long> {
    val millis = remember { mutableStateOf(0L) }
    LaunchedEffect(Unit) {
        val startTime = withFrameMillis { it }
        while (true) {
            withFrameMillis { frameTime ->
                millis.value = frameTime - startTime
            }
            callback.invoke()
        }
    }
    return millis
}
