
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
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
    // Navigasyondan gelen öğrenci numarasını çekiyoruz
    val studentNo = navBackStackEntry?.arguments?.getString("studentNo") ?: ""

    NavigationBar(containerColor = Color.White) {
        // Ana Sayfa
        NavigationBarItem(
            selected = currentRoute?.startsWith("home") == true,
            onClick = { if (studentNo.isNotEmpty()) navController.navigate("home/$studentNo") },
            label = { Text("Ana Sayfa") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") }
        )

        // İŞLEMLER (Artık direkt forma DEĞİL, menüye gidiyor)
        NavigationBarItem(
            selected = currentRoute?.startsWith("actions-menu") == true,
            onClick = {
                if (studentNo.isNotEmpty()) {
                    navController.navigate("actions-menu/$studentNo") {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            },
            label = { Text("İşlemler") },
            icon = { Icon(Icons.Default.Apps, contentDescription = "Menu") }
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