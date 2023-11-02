package com.github.kubode.compose.dropshadow.android

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
