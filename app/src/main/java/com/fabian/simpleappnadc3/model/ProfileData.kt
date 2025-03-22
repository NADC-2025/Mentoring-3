package com.fabian.simpleappnadc3.model

data class ProfileData(
    val id: String = "",
    val name: String = "",
    val title: String = "",
    val email: String = "",
    val bio: String = "",
    val imageUrl: String? = null,
    val skills: List<String> = emptyList()
)