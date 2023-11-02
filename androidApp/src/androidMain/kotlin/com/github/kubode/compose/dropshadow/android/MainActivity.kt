package com.github.kubode.compose.dropshadow.android

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.withSaveLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.kubode.compose.dropshadow.dropShadow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .clip(CircleShape)
                        .dropShadow(Color.Black, 4.dp, 4.dp, 4.dp)
                )
            }
        }
    }
}

@Composable
@Preview
private fun DropShadowPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .shadow(4.dp),
            contentAlignment = Alignment.Center,
        ) {
            BasicText(text = "compose.ui.shadow")
        }
        DropShadow(
            color = Color.Black.copy(alpha = 0.5f),
            dx = 2.dp,
            dy = 2.dp,
            radius = 4.dp,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                BasicText(text = "compose.ui.shadow")
                Box(
                    modifier = Modifier.size(40.dp)
                        .background(Brush.horizontalGradient(listOf(Color.Red, Color.Blue)))
                )
                Image(imageVector = Icons.Outlined.Build, contentDescription = null)
            }
        }
    }
}

@Composable
fun DropShadow(
    color: Color,
    dx: Dp,
    dy: Dp,
    radius: Dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(modifier) {
        Box(
            modifier = Modifier
                .drawWithCache {
                    val dxInPx = dx.toPx()
                    val dyInPx = dy.toPx()
                    val bounds = size.toRect()
                    val paint = Paint().apply {
                        colorFilter = ColorFilter.tint(color)
                    }
                    onDrawWithContent {
                        drawIntoCanvas {
                            it.translate(dx = dxInPx, dy = dyInPx)
                            it.withSaveLayer(bounds, paint) {
                                drawContent()
                            }
                        }
                    }
                }
                .blur(
                    radius = radius,
                    edgeTreatment = BlurredEdgeTreatment.Unbounded
                )
        ) {
            content()
        }
        content()
    }
}
