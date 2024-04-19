package com.mamjadd7.quotesappcomposecheezycode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mamjadd7.quotesappcomposecheezycode.models.Quote
import com.mamjadd7.quotesappcomposecheezycode.screens.QuoteDetails
import com.mamjadd7.quotesappcomposecheezycode.screens.QuoteList
import com.mamjadd7.quotesappcomposecheezycode.screens.QuoteListItem
import com.mamjadd7.quotesappcomposecheezycode.screens.QuoteListScreen
import com.mamjadd7.quotesappcomposecheezycode.ui.theme.QuotesAppComposeCheezyCodeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            DataManager.loadAssetsFromFile(applicationContext)
        }

        setContent {

            QuotesAppComposeCheezyCodeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    App()
                }
            }
        }
    }
}


@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value == Pages.LISTING) {
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        }else{
            DataManager.currentQuote?.let { QuoteDetails(quote = it) }
        }
    }
}

enum class Pages {
    LISTING,
    DETAIL
}


@Composable
fun NotificationCounter(counter: Int, increment: () -> Unit) {

    Column(Modifier.padding(20.dp)) {
        Text(
            text = "You have sent ${counter} Notification"
        )

        Button(onClick = { increment() }) {
            Text(text = "Update Counter")
        }
    }

}

@Composable
fun NotificationSent(counter: Int) {

    Text(
        text = "total notification - $counter "
    )
}

/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    var counter = rememberSaveable {
        mutableStateOf(0)
    }
    QuotesAppComposeCheezyCodeTheme {
        Column {
            NotificationCounter(counter.value) { counter.value++ }
            NotificationSent(counter.value)
        }
    }
}*/
