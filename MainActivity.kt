/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.ai.sample

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.ai.sample.feature.multimodal.PhotoReasoningRoute
import com.google.ai.sample.ui.theme.GenerativeAISample

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GenerativeAISample {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        // Schimbi startDestination în "question_screen"
                        startDestination = "question_screen"
                    ) {
                        composable("question_screen") {
                            // Apelezi QuestionScreen
                            QuestionScreen { allAnswers ->
                                // Aici primești stringul cu toate răspunsurile
                                // Poți să-l salvezi într-un ViewModel sau îl trimiți direct la route
                                // De exemplu, direct navController.navigate("photo_reasoning")
                                val encodedAnswers = Uri.encode(allAnswers)

                                navController.navigate("photo_reasoning?answers=$encodedAnswers")
                            }
                        }

                        composable(
                            route = "photo_reasoning?answers={answers}",
                            arguments = listOf(navArgument("answers") { defaultValue = "" })
                        ) { backStackEntry ->
                            val answersArg = backStackEntry.arguments?.getString("answers") ?: ""
                            PhotoReasoningRoute(answersArg)
                        }

                        // (Opțional) Dacă tot vrei un ecran "menu", îl poți lăsa
                        composable("menu") {
                            MenuScreen(onItemClicked = { routeId ->
                                navController.navigate(routeId)
                            })
                        }
                    }
                }
            }
        }
    }
}
