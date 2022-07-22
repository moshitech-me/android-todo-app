package com.moshitech.to_docompose.navigation.destinations;

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.moshitech.to_docompose.util.Action
import com.moshitech.to_docompose.util.Constants.TASK_ARGUMENT_KEY
import com.moshitech.to_docompose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
        navigateToListScreen: (Action)-> Unit
        ){
        composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
        type = NavType.IntType
        })
        ){

        }
        }