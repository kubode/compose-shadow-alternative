package com.github.kubode.compose.boxshadow

import androidx.compose.ui.graphics.Paint
import org.jetbrains.skia.FilterBlurMode
import org.jetbrains.skia.MaskFilter

internal actual fun Paint.blur(radius: Float) {
    asFrameworkPaint().maskFilter = MaskFilter.makeBlur(
        mode = FilterBlurMode.NORMAL,
        sigma = radius
    )
}
