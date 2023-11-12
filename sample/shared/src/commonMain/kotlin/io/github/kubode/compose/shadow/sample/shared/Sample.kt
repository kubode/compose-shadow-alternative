package io.github.kubode.compose.shadow.sample.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import io.github.kubode.compose.boxshadow.boxShadow

@Composable
public fun Sample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .scrollable(
                state = rememberScrollState(),
                orientation = Orientation.Vertical
            ),
        verticalArrangement = Arrangement.spacedBy(32.dp),
    ) {
        DropShadowSample()
        Box(
            modifier = Modifier
                .size(48.dp)
                .boxShadow(
                    color = Color.Black.copy(alpha = 0.5f),
                    offset = DpOffset(4.dp, 4.dp),
                    radius = 8.dp,
                )
                .background(Color.Red)
        )
        Box(
            modifier = Modifier
                .size(48.dp)
                .boxShadow(
                    color = Color.Black.copy(alpha = 0.5f),
                    offset = DpOffset(4.dp, 4.dp),
                    radius = 8.dp,
                    shape = CircleShape
                )
                .background(Color.Red)
        )
    }
}

@Composable
internal expect fun ColumnScope.DropShadowSample()
