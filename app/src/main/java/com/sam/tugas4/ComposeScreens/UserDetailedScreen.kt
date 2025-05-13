package com.sam.tugas4.ComposeScreens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sam.tugas4.UserViewModel
import com.sam.tugas4.User

@Composable
fun UserDetailScreen(userId: Int, viewModel: UserViewModel) {
    val user by viewModel.selectedUser.collectAsState()

    LaunchedEffect(userId) {
        viewModel.loadUserDetail(userId)
    }

    user?.let {
        Column(Modifier.padding(16.dp)) {
            Text("Name: ${it.name}", style = MaterialTheme.typography.h6)
            Text("Username: ${it.username}")
            Text("Email: ${it.email}")
            Text("Phone: ${it.phone}")
            Text("Website: ${it.website}")
            Spacer(Modifier.height(8.dp))
            Text("Company:", style = MaterialTheme.typography.subtitle1)
            Text("Name: ${it.company.name}")
            Text("Catch Phrase: ${it.company.catchPhrase}")
            Text("BS: ${it.company.bs}")
        }
    } ?: Text("Loading...", Modifier.padding(16.dp))
}