package com.mamjadd7.quotesappcomposecheezycode.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.mamjadd7.quotesappcomposecheezycode.DataManager
import com.mamjadd7.quotesappcomposecheezycode.R
import com.mamjadd7.quotesappcomposecheezycode.models.Quote



@Composable
fun QuoteDetails(quote : Quote) {

    BackHandler {
        DataManager.switchPages(null)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFe3e3e3)
                    )
                )
            )

    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp, 24.dp)
                .background(Color.White)
        ) {
            Image(imageVector = Icons.Filled.FormatQuote,
                contentDescription = "Quotes",
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180F)
            )

            Text(text = quote.text,
                fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Black,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            quote.author?.let {
                Text(text = it,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 10.dp, bottom = 10.dp, end = 10.dp)
                )
            }
        }
    }

}