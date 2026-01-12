package com.yudorm.app.ui

/*
@Composable
fun BottomNavigationBar(
    navController: NavController,
    studentNo: String){

    NavigationBar(
        containerColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val currentStudentNo = navBackStackEntry?.arguments?.getString("studentNo")

        NavigationBarItem(
            selected = currentRoute?.startsWith("home") == true,
            onClick = {
                if (currentRoute?.startsWith("home") == false) {
                   navController.navigate("home/$studentNo") }
                else {
                }
            },
            label = { Text("Ana Sayfa") },
            icon = { Icon(painterResource(R.drawable.home_idon), null) }
        )

        NavigationBarItem(
            selected = currentRoute?.startsWith("actions") == true || currentRoute?.startsWith("issue-management") == true,
            onClick = { navController.navigate("actions/$studentNo") },
            label = { Text("İşlemler") },
            icon = { Icon(painterResource(R.drawable.user_icon), null) }
        )

        NavigationBarItem(
            selected = currentRoute?.startsWith("profile") == true,
            onClick = { navController.navigate("home/$studentNo") },
            label = { Text("Profil") },
            icon = { Icon(painterResource(R.drawable.user_icon), null) }
        )

        NavigationBarItem(
            selected = currentRoute?.startsWith("settings") == true,
            onClick = { navController.navigate("home/$studentNo") },
            label = { Text("Ayarlar") },
            icon = { Icon(painterResource(R.drawable.settings_icon), null) }
        )


    }

}
*/
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val studentNo = navBackStackEntry?.arguments?.getString("studentNo") ?: ""

    NavigationBar(containerColor = Color.White) {
        // Ana Sayfa
        NavigationBarItem(
            selected = currentRoute?.startsWith("home") == true,
            onClick = { if (studentNo.isNotEmpty()) navController.navigate("home/$studentNo") },
            label = { Text("Ana Sayfa") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") }
        )

        // İşlemler (Arkadaşının "submit-issue" rotası)
        NavigationBarItem(
            selected = currentRoute?.startsWith("submit-issue") == true,
            onClick = { if (studentNo.isNotEmpty()) navController.navigate("submit-issue/$studentNo") },
            label = { Text("İşlemler") },
            icon = { Icon(Icons.Default.Build, contentDescription = "Issues") }
        )

        // Profil
        NavigationBarItem(
            selected = currentRoute?.startsWith("profile") == true,
            onClick = { if (studentNo.isNotEmpty()) navController.navigate("profile/$studentNo") },
            label = { Text("Profil") },
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") }
        )

        // Ayarlar
        NavigationBarItem(
            selected = currentRoute?.startsWith("settings") == true,
            onClick = { if (studentNo.isNotEmpty()) navController.navigate("settings/$studentNo") },
            label = { Text("Ayarlar") },
            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") }
        )
    }
}