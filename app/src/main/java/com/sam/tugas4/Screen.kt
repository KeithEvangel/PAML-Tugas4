package com.sam.tugas4

sealed class Screen(val route: String) {
    object UserList : Screen("user_list")
    object UserDetail : Screen("user_detail/{id}") {
        fun createRoute(id: Int) = "user_detail/$id"
    }
}