package com.hitmeows.portfolio_yadav_ashish_02.presentation.rating.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.hitmeows.portfolio_yadav_ashish_02.common.Constants
import com.hitmeows.portfolio_yadav_ashish_02.presentation.rating.FirebaseState

@ExperimentalCoilApi
@Composable
fun AboutSection(
    modifier:Modifier = Modifier,
    state: FirebaseState
) {
    Box(
        modifier = modifier
            .padding(12.dp)
            .height(150.dp)
            .aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {

        if (state.isLoading) CircularProgressIndicator()
        else if (state.link!=null) {
            Image(
                painter = rememberImagePainter(state.link),
                contentDescription = "profile picture",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }

    Text(text = Constants.MY_NAME,
        style = TextStyle(
            color = MaterialTheme.colors.onBackground,
            fontSize = 50.sp,
            fontWeight = FontWeight.Thin
        ),
        modifier = Modifier.padding(4.dp)
    )
    Text(text = Constants.MY_BIO,
        style = TextStyle(
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f),
            fontSize = 20.sp
        ),
        modifier = Modifier.padding(4.dp)
    )
    Spacer(modifier = Modifier.height(17.dp))
    Divider()
}