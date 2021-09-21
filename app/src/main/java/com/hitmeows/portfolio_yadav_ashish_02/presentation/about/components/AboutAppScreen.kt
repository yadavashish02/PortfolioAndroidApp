package com.hitmeows.portfolio_yadav_ashish_02.presentation.about.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp


@Composable
fun AboutAppScreen(
    onClick: () -> Unit
) {

    Column(modifier = Modifier
        .padding(12.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.Start
        ) {
        Text(text = "This app uses firebase realtime database, retrofit (gson and html) and dagger hilt.\nThe UI is purely Jetpack Compose",
            color = MaterialTheme.colors.primary

        )
        Divider()
        Spacer(modifier = Modifier.height(4.dp))

        TextButton(onClick = onClick,
            border = BorderStroke(1.dp, Color.Yellow)
        ) {
            Text(text = "View SourceCode")
        }
    }
}