package com.yudorm.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.yudorm.app.ui.screens.LoginScreen
import com.yudorm.app.ui.theme.YUDormTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yudorm.app.ui.screens.HomeScreen
import com.yudorm.app.ui.screens.RegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YUDormTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "login"){


                    composable("login"){
                        LoginScreen(
                            onLoginSuccess =  { studentNo -> navController.navigate("home") },
                            onPasswordResetButton = { navController.navigate("login")},
                            onAuthorityLoginButton = {navController.navigate("login")},
                            onRegisterButton = {navController.navigate("register")}
                            )
                    }

                    composable("home") { backStackEntry ->
                        HomeScreen()
                    }

                    composable("register") {
                        RegisterScreen(
                            onRegisterSuccess = { navController.navigate("login")},
                            onLoginScreen = {navController.navigate("login")},
                            onAuthorityLoginButton = { navController.navigate("login")}
                        )
                    }

                }
            }
        }
    }
}
