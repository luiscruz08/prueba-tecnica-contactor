package com.lcr.contactos.core

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lcr.contactos.presentation.contacts.ContactsScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Contacts
    ) {
        composable<Contacts>{
            ContactsScreen()
        }
    }
}