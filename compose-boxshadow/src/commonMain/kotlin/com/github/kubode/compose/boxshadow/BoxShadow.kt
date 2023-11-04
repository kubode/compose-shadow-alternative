package com.github.kubode.compose.boxshadow

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

/**
 * Modifier to apply a box shadow.
 *
 * @param color The color of the shadow.
 * @param dx The horizontal offset of the shadow.
 * @param dy The vertical offset of the shadow.
 * @param radius The blur radius of the shadow.
 * @param modifier The modifier to apply to this layout node.
 * @param shape The shape of the shadow.
 */
public fun Modifier.boxShadow(
    color: Color,
    dx: Dp,
    dy: Dp,
    radius: Dp,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
): Modifier = this
