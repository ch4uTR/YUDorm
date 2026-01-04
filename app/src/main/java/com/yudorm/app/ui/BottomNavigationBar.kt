package com.yudorm.app.ui


import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.yudorm.app.R


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
            selected = currentRoute?.startsWith("actions") == true,
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