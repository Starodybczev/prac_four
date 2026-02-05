package com.example.prac_four.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.prac_four.data.vacuumBook

@Composable
fun Header(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""
    val sectionId = navBackStackEntry?.arguments?.getString("id")


    val title = when {
        currentRoute == "main" -> "Vacuum Book"
        sectionId != null -> vacuumBook
            .find { it.id == sectionId }
            ?.title ?: "Section"
        else -> ""
    }

    Row(
        modifier = Modifier
            .background(Color(0xFF2E2E2E))
            .fillMaxWidth()
            .padding(top = 20.dp)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        if (currentRoute.isNotEmpty() && currentRoute != "main") {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF03DAC5),
                    contentColor = Color(0xFF000000)
                ),
                onClick = { navController.popBackStack() }
            ) {
                Text("Back" )
            }
        }

        Text(text = title , color = Color.White, style = MaterialTheme.typography.titleLarge)
    }
}