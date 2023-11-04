package com.github.kubode.compose.shadow.android

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.kubode.compose.dropshadow.DropShadow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
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
                    radius = 4.dp,
                ) {
                    BasicText(text = "DropShadow")
                }
                BasicText(text = "DropShadow")
            }
        }
    }
}
