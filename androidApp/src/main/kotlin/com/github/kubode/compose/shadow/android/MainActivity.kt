package com.github.kubode.compose.shadow.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.github.kubode.compose.dropshadow.DropShadow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
                DropShadow(
                    color = Color.Black.copy(alpha = 0.5f),
                    dx = 2.dp,
                    dy = 2.dp,
                    radius = 2.dp,
                ) {
                    BasicText(text = "DropShadow")
                }
                DropShadow(
                    color = DroidColor.copy(alpha = 0.5f),
                    dx = 4.dp,
                    dy = 4.dp,
                    radius = 8.dp,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_android_black_24dp),
                        contentDescription = null,
                        modifier = Modifier.size(48.dp),
                        colorFilter = ColorFilter.tint(DroidColor),
                    )
                }
                val infiniteTransition = rememberInfiniteTransition(label = "infinite")
                val degrees by infiniteTransition.animateFloat(
                    initialValue = 0f,
                    targetValue = 360f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(durationMillis = 1000, easing = LinearEasing)
                    ),
                    label = "degrees",
                )
                DropShadow(
                    color = DroidColor.copy(alpha = 0.5f),
                    dx = 4.dp,
                    dy = 4.dp,
                    radius = 8.dp,
                    drawInvalidationTrigger = { degrees },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_android_black_24dp),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .rotate(degrees),
                        colorFilter = ColorFilter.tint(DroidColor),
                    )
                }
            }
        }
    }
}

private val DroidColor = Color(0xFF3DDC84)
