package com.github.kubode.compose.dropshadow

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

public actual fun Modifier.dropShadow(
    color: Color,
    dx: Dp,
    dy: Dp,
    radius: Dp
): Modifier = this
