package com.example.prac_four

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.prac_four.components.SectionCard
import com.example.prac_four.types.BookSection
import kotlinx.coroutines.delay

@Composable
fun App(
    naveControl: NavHostController,
    vacuumBook: List<BookSection>
) {
    val focusManager = LocalFocusManager.current
    var search by remember() { mutableStateOf("") }
    var debouncedSearch by remember { mutableStateOf("") }

    LaunchedEffect(search) {
        delay(300)
        debouncedSearch = search
    }

    val filtered = remember ( vacuumBook , debouncedSearch){
        vacuumBook.filter { el -> el.title.lowercase().contains(debouncedSearch.lowercase()) }
    }

    Column(
        modifier = Modifier
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                focusManager.clearFocus()
            }
            .fillMaxSize()
            .padding(
                start = 5.dp,
                end = 5.dp,
                top = 16.dp,
                bottom = 20.dp
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = "Select Book"
        )

        OutlinedTextField(
            value = search,
            onValueChange = { search = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            label = { Text("Search") }
        )

        if(filtered.isEmpty()){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(
                    space = 16.dp,
                    alignment = Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally,

                ){
                Text(
                    "Not found Tasks",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }else{
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                items(filtered, key = { it.id }) { section ->
                    SectionCard(
                        section = section,
                        onClick = {
                            naveControl.navigate("section/${section.id}")
                        }
                    )
                }

                item {
                    Button(
                        onClick = { naveControl.navigate("about_us") },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("AboutUs", color = Color.White)
                    }
                }
            }
        }
    }
}

