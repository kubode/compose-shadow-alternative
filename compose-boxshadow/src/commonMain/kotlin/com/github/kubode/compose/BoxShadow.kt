package com.github.kubode.compose

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

public fun Modifier.boxShadow(
    color: Color,
    dx: Dp,
    dy: Dp,
    radius: Dp,
    shape: Shape = RectangleShape,
): Modifier = this
