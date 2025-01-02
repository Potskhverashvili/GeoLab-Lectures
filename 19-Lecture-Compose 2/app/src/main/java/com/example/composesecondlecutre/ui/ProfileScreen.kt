package com.example.composesecondlecutre.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composesecondlecutre.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    // ------- Scaffold ----------
    Scaffold(
        // --- Top Bar ---
        topBar = {
            // --- LargeTopBar ---
            LargeTopAppBar(
                // --- Title ---
                title = {
                    Text(
                        text = "My Profile",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 34.sp
                    )
                },
                // --- actions ---
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Search, contentDescription = null)
                    }
                },
                // --- navigationIcon ---
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Menu, contentDescription = null)
                    }
                }
            )
        },

        // --- Bottom Bar ---
        bottomBar = {
            // --- Navigation Bar ---
            NavigationBar {
                // --- Item 1 ---
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.Person, contentDescription = null)
                    },
                    label = { Text(text = "Profile") }
                )
                // --- Item 2 ---
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.Home, contentDescription = null)
                    },
                    label = { Text(text = "Home") }
                )
                // --- Item 3 ---
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.FavoriteBorder, contentDescription = null)
                    },
                    label = { Text(text = "Favorite") }
                )
            }
        }
    ) { paddingValue ->
        Column(
            modifier = Modifier.padding(paddingValue)
        ) {
            // --- User Profile ---
            UserItem()
            Spacer(modifier = Modifier.height(28.dp))

            // ---Profile Elements ---
            ProfileOptionItem(
                "My Orders",
                "Already have 12 orders"
            )
            ProfileOptionItem(
                "Shipping Addresses",
                "3 Addresses"
            )
            ProfileOptionItem(
                "Settings",
                "Notifications, password"
            )
        }
    }
}

// -------- User Item ------------
@Composable
fun UserItem() {
    Row(
        modifier = Modifier.padding(horizontal = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(64.dp),
            painter = painterResource(R.drawable.img_profile_picture),
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(18.dp))
        Column {
            Text(
                text = "Matilda Brown",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
            Text(
                text = "matildabrown@gmail.com",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}

// ------ Profile Element -----------
@Composable
fun ProfileOptionItem(
    text: String,
    description: String
) {
    Row(
        modifier = Modifier
            .padding(
                vertical = 18.dp,
                horizontal = 16.dp
            )
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = description,
                fontSize = 16.sp
            )
        }
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()
}