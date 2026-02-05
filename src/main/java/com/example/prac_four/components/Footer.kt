package com.example.prac_four.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun Footer() {
    val context = LocalContext.current
    val appName = context.applicationInfo
        .loadLabel(context.packageManager)
        .toString()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2E2E2E))
            .padding(0.dp, 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Design by Wiktor Dev", color = Color.White)
        Text(
            text = appName,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
    }
}