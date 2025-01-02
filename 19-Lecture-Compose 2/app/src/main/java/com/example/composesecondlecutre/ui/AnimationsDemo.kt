package com.example.composesecondlecutre.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimationsDemo() {

    var email by remember { mutableStateOf("") }
    var isLogin by remember { mutableStateOf(true) }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // ------------------------- AnimatedContentSize -------------------------
        Text(
            modifier = Modifier.animateContentSize(),
            text = if (isLogin) "Log in" else "Register",
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )

        // -------------------------- Crossfade -------------------------
        /* Crossfade(targetState = isLogin, label = "Label") {
             if (it) {
                 Text(
                     modifier = Modifier.fillMaxWidth(),
                     text = "Log in",
                     fontSize = 28.sp,
                     textAlign = TextAlign.Center
                 )
             } else {
                 Text(
                     modifier = Modifier.fillMaxWidth(),
                     text = "Register",
                     fontSize = 28.sp,
                     textAlign = TextAlign.Center
                 )
             }
         }*/

        // ---------------------------------- Text Fields --------------------------
        Spacer(modifier = Modifier.height(32.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") }
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") }
        )

        // ------------------------------- AnimatedVisibility ----------------------
        AnimatedVisibility(
            visible = !isLogin,
            /*
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
            */
        ) {
            TextField(
                value = repeatPassword,
                onValueChange = { repeatPassword = it },
                label = { Text(text = "Password") }
            )
        }

        TextButton(
            onClick = { isLogin = !isLogin }
        ) {
            Text(
                modifier = Modifier.animateContentSize(),
                text = if (isLogin) "Create an account" else "Log in to existing account"
            )
        }
    }
}

@Preview
@Composable
private fun AnimationsDemoPreview() {
    AnimationsDemo()
}