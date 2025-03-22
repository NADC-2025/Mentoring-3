package com.fabian.simpleappnadc3.ui.screens

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.fabian.simpleappnadc3.data.ProfileRepository
import com.fabian.simpleappnadc3.model.ProfileData
import com.fabian.simpleappnadc3.ui.components.ProfileCard
import com.fabian.simpleappnadc3.ui.theme.SimpleAppNADC3Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    var profileData by remember { mutableStateOf(ProfileRepository.defaultProfile) }
    var showEditScreen by remember { mutableStateOf(false) }

    val context = LocalContext.current

    if (showEditScreen) {
        ProfileEditScreen(
            initialProfile = profileData,
            onNavigateBack = { showEditScreen = false },
            onSave = { updatedProfile ->
                profileData = updatedProfile
                showEditScreen = false
                Toast.makeText(context, "Profile updated", Toast.LENGTH_SHORT).show()
            }
        )
    } else {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Profile") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.TopCenter
            ) {
                ProfileCard(
                    profileData = profileData,
                    onEditClick = { showEditScreen = true },
                    onEmailClick = {
                        val intent = Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("mailto:${profileData.email}")
                        }
                        try {
                            context.startActivity(intent)
                        } catch (e: Exception) {
                            Toast.makeText(
                                context,
                                "No email app found",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    SimpleAppNADC3Theme {
        ProfileScreen()
    }
}