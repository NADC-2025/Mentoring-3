package com.fabian.simpleappnadc3.data

import com.fabian.simpleappnadc3.model.MenuItem

object MenuRepository {
    fun getMenuItems(): List<MenuItem> {
        return listOf(
            MenuItem(1, "Dinner club"),
            MenuItem(2, "Lunch special"),
            MenuItem(3, "Breakfast combo")
        )
    }
}