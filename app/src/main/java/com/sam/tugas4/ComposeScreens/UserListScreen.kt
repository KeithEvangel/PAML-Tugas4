package com.sam.tugas4.ComposeScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sam.tugas4.Screen
import com.sam.tugas4.UserViewModel


@Composable
fun UserListScreen(navController: NavController, viewModel: UserViewModel) {
    val users by viewModel.userList.collectAsState()

    LazyColumn {
        items(users) { user ->
            Column(
                Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(Screen.UserDetail.createRoute(user.id))
                    }
                    .padding(16.dp)
            ) {
                Text(user.name, style = MaterialTheme.typography.h6)
                Text(user.email, style = MaterialTheme.typography.body2)
            }
        }
    }
}