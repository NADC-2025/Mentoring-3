package com.fabian.simpleappnadc3.model

data class MenuItem(
    val id: Int,
    val name: String,
    val isSelected: Boolean = false
)