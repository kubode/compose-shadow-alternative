package com.github.kubode.compose.boxshadow

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset

/**
 * Modifier to apply a box shadow.
 *
 * @param color The color of the shadow.
 * @param offset The offset of the shadow.
 * @param radius The blur radius of the shadow.
 * @param modifier The modifier to apply to this layout node.
 * @param shape The shape of the shadow.
 */
public fun Modifier.boxShadow(
    color: Color,
    offset: DpOffset,
    radius: Dp,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
): Modifier = this
