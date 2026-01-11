package com.yudorm.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.yudorm.app.ui.screens.LoginScreen
import com.yudorm.app.ui.theme.YUDormTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
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

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val showBottomBar = currentRoute != "login" && currentRoute != "register"

                Scaffold( bottomBar = { if(showBottomBar) { BottomNavigationBar(navController) } } ) { innerPadding ->
                    NavHost(navController = navController, startDestination = "login", modifier = Modifier.padding(innerPadding)){
                        composable("login"){ backStackEntry ->

                            val studentNoPath = backStackEntry.arguments?.getString("studentNo") ?: ""

                            LoginScreen(
                                viewModel = loginViewModel,
                                onLoginSuccess =  { loggedInNo -> navController.navigate("home/$loggedInNo"){ popUpTo("login") {inclusive = true} } },
                                onPasswordResetButton = { },
                                onAuthorityLoginButton = { },
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
}

