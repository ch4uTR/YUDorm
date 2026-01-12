package com.yudorm.app.ui

import BottomNavigationBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yudorm.app.ui.screens.ActionsScreen
import com.yudorm.app.ui.screens.ForgotPasswordScreen
import com.yudorm.app.ui.screens.HomeScreen
import com.yudorm.app.ui.screens.IssueListScreen
import com.yudorm.app.ui.screens.IssueScreen
import com.yudorm.app.ui.screens.IssueSuccessScreen
import com.yudorm.app.ui.screens.LaundryScreen
import com.yudorm.app.ui.screens.LoginScreen
import com.yudorm.app.ui.screens.LostItemFormScreen
import com.yudorm.app.ui.screens.LostItemListScreen
import com.yudorm.app.ui.screens.ManagementScreen
import com.yudorm.app.ui.screens.ProfileScreen
import com.yudorm.app.ui.screens.RegisterScreen
import com.yudorm.app.ui.screens.SettingsScreen
import com.yudorm.app.ui.theme.YUDormTheme
import com.yudorm.app.ui.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YUDormTheme {
                val navController = rememberNavController()
                val loginViewModel: LoginViewModel = viewModel()

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val showBottomBar = currentRoute != "login" && currentRoute != "register"

                Scaffold(
                    bottomBar = {
                        if (showBottomBar) {
                            BottomNavigationBar(navController)
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        // 1. GİRİŞ VE KAYIT AKIŞI
                        composable("login") {
                            LoginScreen(
                                viewModel = loginViewModel,
                                onLoginSuccess = { loggedInNo ->
                                    navController.navigate("home/$loggedInNo") {
                                        popUpTo("login") { inclusive = true }
                                    }
                                },
                                onPasswordResetButton = { navController.navigate("forgot-password") },
                                onRegisterButton = { navController.navigate("register") },
                                onAuthorityLoginButton = { }
                            )
                        }

                        composable("register") {
                            RegisterScreen(
                                onRegisterSuccess = { navController.navigate("login") },
                                onLoginScreen = { navController.navigate("login") },
                                onAuthorityLoginButton = { navController.navigate("login") }
                            )
                        }

                        composable("forgot-password") {
                            ForgotPasswordScreen(onBack = { navController.popBackStack() })
                        }

                        // 2. ANA SAYFA VE İŞLEMLER MENÜSÜ
                        composable("home/{studentNo}") { backStackEntry ->
                            val studentNoPath =
                                backStackEntry.arguments?.getString("studentNo") ?: ""
                            HomeScreen(
                                loginViewModel = loginViewModel,
                                onIssueButton = { navController.navigate("actions-menu/$studentNoPath") }
                            )
                        }

                        composable("actions-menu/{studentNo}") { backStackEntry ->
                            val studentNo = backStackEntry.arguments?.getString("studentNo") ?: ""
                            ActionsScreen(navController, studentNo)
                        }

                        // 3. ARIZA KAYDI AKIŞI
                        composable("issue-mgmt/{studentNo}") { backStackEntry ->
                            val no = backStackEntry.arguments?.getString("studentNo") ?: ""
                            ManagementScreen(
                                title = "Arıza Kayıtları",
                                onNewClick = { navController.navigate("submit-issue/$no") },
                                onListClick = { navController.navigate("issue-list/$no") }
                            )
                        }

                        composable("submit-issue/{studentNo}") { backStackEntry ->
                            val no = backStackEntry.arguments?.getString("studentNo") ?: ""
                            IssueScreen(
                                studentNo = no,
                                onSubmissionSuccess = {
                                    navController.navigate("success-screen/issue/$no")
                                }
                            )
                        }

                        composable("issue-list/{studentNo}") { backStackEntry ->
                            val no = backStackEntry.arguments?.getString("studentNo") ?: ""
                            IssueListScreen(studentNo = no)
                        }

                        // 4. KAYIP EŞYA AKIŞI
                        composable("lost-mgmt/{studentNo}") { backStackEntry ->
                            val no = backStackEntry.arguments?.getString("studentNo") ?: ""
                            ManagementScreen(
                                title = "Kayıp Eşya Kayıtları",
                                onNewClick = { navController.navigate("lost-form/$no") },
                                onListClick = { navController.navigate("lost-list/$no") }
                            )
                        }

                        composable("lost-form/{studentNo}") { backStackEntry ->
                            val no = backStackEntry.arguments?.getString("studentNo") ?: ""
                            LostItemFormScreen(
                                studentNo = no,
                                onBack = { navController.popBackStack() },
                                onSuccess = {
                                    navController.navigate("success-screen/lost/$no")
                                }
                            )
                        }

                        composable("lost-list/{studentNo}") { backStackEntry ->
                            val no = backStackEntry.arguments?.getString("studentNo") ?: ""
                            LostItemListScreen(studentNo = no)
                        }

                        // 5. ORTAK BAŞARI EKRANI (PENGUENLİ)
                        composable("success-screen/{type}/{studentNo}") { backStackEntry ->
                            val type = backStackEntry.arguments?.getString("type") ?: ""
                            val no = backStackEntry.arguments?.getString("studentNo") ?: ""
                            val message = if (type == "issue") "Arıza Kaydı" else "Kayıp Eşya Kaydı"

                            IssueSuccessScreen(
                                message = message,
                                onNavigateHome = {
                                    navController.navigate("home/$no") {
                                        popUpTo("home/$no") { inclusive = true }
                                    }
                                }
                            )
                        }

                        // 6. PROFİL VE AYARLAR
                        composable("profile/{studentNo}") { backStackEntry ->
                            val studentNo =
                                backStackEntry.arguments?.getString("studentNo") ?: "Bilinmiyor"
                            ProfileScreen(studentNo = studentNo)
                        }

                        composable("settings/{studentNo}") { backStackEntry ->
                            val studentNo = backStackEntry.arguments?.getString("studentNo") ?: ""
                            SettingsScreen(studentNo = studentNo)
                        }

                        composable("laundry-mgmt/{studentNo}") { backStackEntry ->
                            val no = backStackEntry.arguments?.getString("studentNo") ?: ""
                            LaundryScreen(status = "READY")
                        }


                    }
                }
            }
        }
    }
}

