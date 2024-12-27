package com.example.composefirstlecture.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composefirstlecture.R


@Composable
fun LazyColumnExample() {

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        items(5) { index ->
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { }
                    .clip(RoundedCornerShape(24.dp)) //clip(CircleShape)
                    .background(Color.LightGray),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {

                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )

                Text("Item $index")
            }
        }

        item {
            CircularProgressIndicator()
        }

        items(5) { index ->
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { }
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color.Green),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
                Text("Item $index")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LazyColumnPreview() {
    LazyColumnExample()
}
