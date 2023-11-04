package com.github.kubode.compose.boxshadow

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.addOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset

/**
 * Modifier to apply a box shadow.
 *
 * This modifier applies box shadow and [clip] according to [shape].
 *
 * @param color The color of the shadow.
 * @param offset The offset of the shadow.
 * @param radius The blur radius of the shadow.
 * @param shape The shape of the shadow.
 */
public fun Modifier.boxShadow(
    color: Color,
    offset: DpOffset,
    radius: Dp,
    shape: Shape = RectangleShape,
): Modifier = this
    .drawWithCache {
        val paint = Paint().apply {
            this.color = color
            blur(radius.toPx())
        }
        val outline = shape.createOutline(
            size = size,
            layoutDirection = layoutDirection,
            density = this,
        )
        val path = Path().apply {
            addOutline(outline)
        }
        val left = offset.x.toPx()
        val top = offset.y.toPx()
        onDrawBehind {
            drawIntoCanvas { canvas ->
                withTransform({
                    clipPath(path = path, clipOp = ClipOp.Difference)
                    translate(left = left, top = top)
                }) {
                    canvas.drawPath(path, paint)
                }
            }
        }
    }
    .clip(shape)

internal expect fun Paint.blur(radius: Float)
