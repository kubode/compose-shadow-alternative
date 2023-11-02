package com.github.kubode.compose.dropshadow

import android.graphics.Bitmap
import android.graphics.BlurMaskFilter
import android.graphics.ColorFilter
import android.graphics.PorterDuffXfermode
import android.graphics.Xfermode
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.withSaveLayer
import androidx.compose.ui.unit.Dp

public actual fun Modifier.dropShadow(
    color: Color,
    dx: Dp,
    dy: Dp,
    radius: Dp
): Modifier =  drawWithCache {
    val paint = Paint().apply {
        this.color = color
        asFrameworkPaint().apply {
            maskFilter = BlurMaskFilter(
                radius.toPx(),
                BlurMaskFilter.Blur.NORMAL
            )
        }
    }
    onDrawWithContent {
        val bitmap = Bitmap.createBitmap(size.width.toInt(), size.height.toInt(), Bitmap.Config.ARGB_8888)
//        drawContent()
        with(drawContext.canvas.nativeCanvas) {
            saveLayer(0f, 0f, size.width, size.height, paint.asFrameworkPaint())
            drawContent()
            restore()
        }
//        drawContext.canvas.withSaveLayer(size.toRect(), paint) {
//            drawContent()
//        }
//        Canvas(c = drawContext.canvas.nativeCanvas).nativeCanvas
//        android.graphics.Canvas(bitmap).apply {
//            this.drawRect(0f, 0f, size.width, size.height, paint.asFrameworkPaint())
//        }
//        drawContext.canvas.nativeCanvas.drawBitmap(bitmap, 0f, 0f, paint.asFrameworkPaint())
//        drawContent()
//        val bitmap = ImageBitmap(width = size.width.toInt(), height = size.height.toInt())
        drawContext.canvas
//        val canvas = Canvas(c = drawContext.canvas.)
        drawIntoCanvas {
//            it.drawRect(drawContext.size.toRect(), paint)
        }
    }
//    onDrawBehind {
//        drawRect(color, Offset(dx.toPx(), dy.toPx()), size = size, alpha = 0.5f, style = Stroke(width = radius.toPx()))
//    }
}
