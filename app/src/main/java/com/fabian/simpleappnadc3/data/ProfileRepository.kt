package com.fabian.simpleappnadc3.data

import com.fabian.simpleappnadc3.model.ProfileData

object ProfileRepository {
    // Sample profile data
    val defaultProfile = ProfileData(
        id = "1",
        name = "Jane Doe",
        title = "Android Developer",
        email = "jane.doe@example.com",
        bio = "Passionate Android developer with experience in Jetpack Compose. I love creating beautiful and functional UI components.",
        skills = listOf("Kotlin", "Jetpack Compose", "Android")
    )
}