package com.yudorm.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.yudorm.app.ui.screens.LoginScreen
import com.yudorm.app.ui.theme.YUDormTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yudorm.app.ui.screens.HomeScreen
import com.yudorm.app.ui.screens.IssueScreen
import com.yudorm.app.ui.screens.RegisterScreen
import com.yudorm.app.ui.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YUDormTheme {

                val navController = rememberNavController()
                val loginViewModel :LoginViewModel = viewModel();
                NavHost(navController = navController, startDestination = "login"){


                    composable("login"){ backStackEntry ->

                        val studentNoPath = backStackEntry.arguments?.getString("studentNo") ?: ""

                        LoginScreen(
                            viewModel = loginViewModel,
                            onLoginSuccess =  { studentNo -> navController.navigate("home/$studentNoPath") },
                            onPasswordResetButton = { navController.navigate("login")},
                            onAuthorityLoginButton = {navController.navigate("login")},
                            onRegisterButton = {navController.navigate("register")}
                            )
                    }

                    composable("home/{studentNo}") { backStackEntry ->
                        val studentNoPath = backStackEntry.arguments?.getString("studentNo") ?: ""
                        HomeScreen(
                            loginViewModel = loginViewModel,
                            onIssueButton = { navController.navigate(route = "submit-issue/$studentNoPath") }
                        )
                    }

                    composable("register") {
                        RegisterScreen(
                            onRegisterSuccess = { navController.navigate("login")},
                            onLoginScreen = {navController.navigate("login")},
                            onAuthorityLoginButton = { navController.navigate("login")}
                        )
                    }

                    composable(route="submit-issue/{studentNo}") { backStackEntry ->
                        val studentNoPath = backStackEntry.arguments?.getString("studentNo") ?: ""

                        IssueScreen(
                            studentNo = studentNoPath,
                            onSubmissionSuccess = {navController.navigate("home/$studentNoPath")}
                        )
                    }
                }
            }
        }
    }
}
