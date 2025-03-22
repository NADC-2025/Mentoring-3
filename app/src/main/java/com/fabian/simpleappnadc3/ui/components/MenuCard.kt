package com.fabian.simpleappnadc3.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fabian.simpleappnadc3.model.MenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuCard(
    menuItem: MenuItem,
    onMenuItemClick: (MenuItem) -> Unit
) {
    Card(
        modifier = Modifier.padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (menuItem.isSelected) MaterialTheme.colorScheme.primaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        ),
        onClick = { onMenuItemClick(menuItem) }
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = menuItem.name,
            style = MaterialTheme.typography.bodyLarge,
            color = if (menuItem.isSelected) MaterialTheme.colorScheme.onPrimaryContainer
            else MaterialTheme.colorScheme.onSurface
        )
    }
}