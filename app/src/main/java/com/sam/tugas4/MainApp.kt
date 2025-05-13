package com.sam.tugas4

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sam.tugas4.ComposeScreens.UserDetailScreen
import com.sam.tugas4.ComposeScreens.UserListScreen

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val viewModel: UserViewModel = viewModel()

    NavHost(navController, startDestination = Screen.UserList.route) {
        composable(Screen.UserList.route) {
            UserListScreen(navController, viewModel)
        }
        composable("user_detail/{id}", arguments = listOf(navArgument("id") { type = NavType.IntType })) { backStackEntry ->
            val userId = backStackEntry.arguments?.getInt("id") ?: 0
            UserDetailScreen(userId, viewModel)
        }
    }
}