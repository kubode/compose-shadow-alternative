package io.github.kubode.compose.boxshadow

import android.graphics.BlurMaskFilter
import androidx.compose.ui.graphics.Paint

internal actual fun Paint.blur(radius: Float) {
    asFrameworkPaint().maskFilter =
        BlurMaskFilter(radius, BlurMaskFilter.Blur.NORMAL)
}
