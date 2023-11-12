import androidx.compose.ui.window.Window
import io.github.kubode.compose.shadow.sample.shared.Sample
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    onWasmReady {
        Window("Compose Shadow Alternative") {
            Sample()
        }
    }
}
