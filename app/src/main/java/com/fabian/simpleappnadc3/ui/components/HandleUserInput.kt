package com.fabian.simpleappnadc3.ui.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions



@Composable
fun SimpleOutlinedTextFieldSample() {
    var numberText by remember { mutableStateOf("") }
    var numberValue by remember { mutableStateOf<Int?>(null) }

    OutlinedTextField(
        value = numberText,
        onValueChange = {
            if (it.all { char -> char.isDigit() }) { // Pastikan hanya angka
                numberText = it
                numberValue = it.toIntOrNull() // Tidak pakai !!
            }
        },
        label = { Text("Masukkan angka") },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
    )
}
