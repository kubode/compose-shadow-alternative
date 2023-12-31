package io.github.kubode.compose.shadow.sample.shared

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kubode.compose.dropshadow.DropShadow

@Composable
internal actual fun ColumnScope.DropShadowSample() {
    DropShadow(
        color = Color.Black.copy(alpha = 0.5f),
        offset = DpOffset(2.dp, 2.dp),
        radius = 2.dp,
        modifier = Modifier
            .border(1.dp, Color.Black)
            .padding(16.dp),
    ) {
        BasicText(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = Color(0xFF37BF6E))) {
                    append("Compose")
                }
                append(" ")
                withStyle(SpanStyle(color = Color(0xFF041619))) {
                    append("Shadow")
                }
                append(" ")
                withStyle(SpanStyle(color = Color(0xFF3870B2))) {
                    append("Alternative")
                }
            },
            style = TextStyle.Default.copy(fontSize = 24.sp)
        )
    }
    DropShadow(
        color = Color.Black,
        offset = DpOffset(4.dp, 4.dp),
        radius = 8.dp,
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .border(4.dp, Color.Black, RoundedCornerShape(8.dp)),
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
        offset = DpOffset(4.dp, 4.dp),
        radius = 8.dp,
        drawInvalidationTrigger = { degrees },
    ) {
        Image(
            imageVector = Icons.Outlined.Phone,
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .rotate(degrees),
            colorFilter = ColorFilter.tint(DroidColor),
        )
    }
}

private val DroidColor = Color(0xFF3DDC84)
