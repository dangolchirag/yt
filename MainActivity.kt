package com.chat.lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chat.lazycolumn.ui.theme.LazyColumnTheme


val items = listOf(
    ListItem(
        imageRes = R.drawable.sun,
        title = "Sun",
        description = "Star of our solar system."
    ),
    ListItem(
        imageRes = R.drawable.mercury,
        title = "Mercury",
        description = "Closest to the sun."
    ),
    ListItem(
        imageRes = R.drawable.venus,
        title = "Venus",
        description = "Second planet from the sun."
    ),
    ListItem(
        imageRes = R.drawable.earth,
        title = "Earth",
        description = "Third planet from the sun"
    ),
    ListItem(
        imageRes = R.drawable.mars,
        title = "Mars",
        description = "Fourth planet from the sun."
    ),
    ListItem(
        imageRes = R.drawable.jupiter,
        title = "Jupiter",
        description = "Fifth planet from the sun."
    ),
    ListItem(
        imageRes = R.drawable.saturn,
        title = "Saturn",
        description = "Sixth planet from the sun."
    ),
    ListItem(
        imageRes = R.drawable.uranus,
        title = "Uranus",
        description = "Seventh planet from the sun."
    ),
    ListItem(
        imageRes = R.drawable.neptune,
        title = "Neptune",
        description = "Eighth planet from the sun."
    ),
    ListItem(
        imageRes = R.drawable.pluto,
        title = "Pluto",
        description = "Dwarf planet in the Kuiper Belt."
    )
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyColumnTheme {
                LazyColumnWithImageAndTextExample()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyColumnWithImageAndTextExample() {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Solar System",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                modifier = Modifier.fillMaxWidth(),
            )
        }) { innerPadding ->

        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(items, key = { it.title }) { item ->
                ItemScreen(item)
            }
        }
    }
}



data class ListItem(
    val imageRes: Int,
    val title: String,
    val description: String
)

@Composable
fun ItemScreen(item: ListItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Row {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.title,
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .padding(8.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumnWithImageAndTextExamplePreview() {
    LazyColumnTheme {


    }
}
