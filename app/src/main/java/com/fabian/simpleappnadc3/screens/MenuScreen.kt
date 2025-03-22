package com.fabian.simpleappnadc3.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabian.simpleappnadc3.ui.theme.SimpleAppNADC3Theme

@Composable
fun MainScreen() {
    var userInput by remember { mutableStateOf("") }
    var numberValue by remember { mutableStateOf<Int?>(null) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = userInput,
                onValueChange = {
                    if (it.all { char -> char.isDigit() }) { // Filter hanya angka
                        userInput = it
                        numberValue = it.toIntOrNull()
                    }
                },
                label = { Text("Masukkan angka") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

//            Spacer(modifier = Modifier.height(16.dp))
//
//            Text(
//                text = "Input Angka: ${numberValue ?: "Belum ada"}",
//                style = MaterialTheme.typography.bodyLarge
//            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    SimpleAppNADC3Theme {
        MainScreen()
    }
}
