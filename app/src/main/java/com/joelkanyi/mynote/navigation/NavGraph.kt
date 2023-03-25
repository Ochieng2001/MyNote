package com.joelkanyi.mynote.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.joelkanyi.mynote.screen.AddNoteScreen
import com.joelkanyi.mynote.screen.NotesScreen


@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screen.Notes.route) {
        composable(route = Screen.Notes.route) {
            NotesScreen(navController = navController)
        }

        composable(
            route = Screen.AddNote.route,
            arguments = listOf(
                navArgument(name = TITLE){
                    defaultValue = ""
                    type = NavType.StringType
                },
                navArgument(name = CONTENT) {
                    defaultValue = ""
                    type = NavType.StringType
                },
                navArgument(name = ID) {
                    defaultValue = -1
                    type = NavType.IntType
                }
            )
        ) { navBackStackEntry ->
            AddNoteScreen(
                navController = navController,
                title = navBackStackEntry.arguments?.getString(TITLE) ?: "",
                content = navBackStackEntry.arguments?.getString(CONTENT) ?: "",
                id = navBackStackEntry.arguments?.getInt(ID)
            )
        }
    }
}
