package com.example.prac_four.pages

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun AboutAs() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "About author",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "If you have feedback or suggestions, feel free to contact.",
            style = MaterialTheme.typography.bodyMedium
        )

        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:starodubcevviktor202@gmail.com")
                    putExtra(Intent.EXTRA_SUBJECT, "Vacuum Book feedback")
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "Hello!\n\nI want to leave feedback about the Vacuum Book app."
                    )
                }
                context.startActivity(intent)
            }
        ) {
            Text("Send feedback")
        }

        Button(
            onClick = {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://wikto1133.netlify.app/")
                )
                context.startActivity(intent)
            }
        ) {
            Text("Open website")
        }
    }
}
