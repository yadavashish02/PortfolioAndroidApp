package com.hitmeows.portfolio_yadav_ashish_02.presentation.rating.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hitmeows.portfolio_yadav_ashish_02.presentation.rating.CodeforcesState

@Composable
fun CodeforcesView(
    modifier: Modifier = Modifier,
    state: CodeforcesState
) {

    Column(

        modifier = modifier
            .padding(12.dp)
            .border(2.dp, Color.Gray, RoundedCornerShape(10.dp))
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (state.isLoading) CircularProgressIndicator()
        else if (state.info!=null) {
            Text(text = state.info.rating.toString(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 1.sp
                )
            )
        }
        Text(text = "Codeforces")
    }
}