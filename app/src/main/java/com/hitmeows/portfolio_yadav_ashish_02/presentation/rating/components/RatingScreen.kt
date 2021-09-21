package com.hitmeows.portfolio_yadav_ashish_02.presentation.rating.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.hitmeows.portfolio_yadav_ashish_02.presentation.rating.RatingScreenViewmodel

@ExperimentalCoilApi
@Composable
fun RatingScreen(
    viewModel: RatingScreenViewmodel = hiltViewModel()
) {
    val cfState = viewModel.cfState.value
    val ccState = viewModel.ccState.value
    val fbState = viewModel.fbState.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            AboutSection(state = fbState)
            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Top
            ) {
                CodeforcesView(
                    modifier = Modifier
                        .weight(3f),
                    state = cfState
                )
                CodechefView(
                    modifier = Modifier
                        .weight(3f),
                    state = ccState
                )
            }
        }
    }
}