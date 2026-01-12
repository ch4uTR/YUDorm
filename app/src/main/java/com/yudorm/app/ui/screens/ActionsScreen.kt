package com.yudorm.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.yudorm.app.R

@Composable
fun ActionsScreen(navController: NavController, studentNo: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "İşlemler", 
            fontSize = 24.sp, 
            fontWeight = FontWeight.Bold, 
            modifier = Modifier.padding(bottom = 8.dp, top = 16.dp)
        )

        // Arıza Kaydı Kartı
        ImageActionButton(
            title = "Arıza Kaydı",
            imgRes = R.drawable.ariza_kaydi,
            onClick = { navController.navigate("issue-management/$studentNo") }
        )

        // Çamaşırhane Kartı
        ImageActionButton(
            title = "Çamaşırhane",
            imgRes = R.drawable.camasirhane,
            onClick = { /* navController.navigate("laundry-mgmt/$studentNo") */ }
        )

        // Kayıp Eşya Kartı
        ImageActionButton(
            title = "Kayıp Eşya",
            imgRes = R.drawable.kayip_esya,
            onClick = { /* navController.navigate("lost-mgmt/$studentNo") */ }
        )

        // Diğer Kartı
        ImageActionButton(
            title = "Diğer",
            imgRes = R.drawable.diger,
            onClick = { /* Diğer işlemler */ }
        )
    }
}

@Composable
fun ImageActionButton(
    title: String,
    imgRes: Int,
    height: Int = 118,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(height.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = imgRes),
                contentDescription = title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Metnin okunabilirliği için metni hizalıyoruz
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color.Black, // Görsellerin koyuluğuna göre White da yapabilirsin
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 24.dp)
            )
        }
    }
}

@Composable
fun IssueManagementScreen(
    studentNo: String,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Arıza Kayıtları",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            text = "Arıza kayıtlarını kontrol etmek ve yeni bir arıza kaydı oluşturmak için lütfen devam edin.",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        ImageActionButton(
            title = "Yeni Kayıt Oluştur",
            imgRes = R.drawable.kayit_olustur,
            onClick = { navController.navigate("submit-issue/$studentNo") },
            height = 180
        )

        ImageActionButton(
            title = "Arıza Kayıtlarım",
            imgRes = R.drawable.kayitlarim,
            onClick = { /* Kayıtlarım listesine git */ },
            height = 180
        )
    }
}