package com.yudorm.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.yudorm.app.R


@Composable
fun ActionsScreen(navController: NavController, studentNo: String) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState())
    ) {
        Text("İşlemler", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 24.dp))

        // Arıza Kaydı Kartı
        ActionCard(
            title = "Arıza Kaydı",
            imageRes = R.drawable.ariza_kaydi, // Sendeki drawable ismi
            onClick = { navController.navigate("issue-mgmt/$studentNo") }
        )

        // Çamaşırhane Kartı
        ActionCard(
            title = "Çamaşırhane",
            imageRes = R.drawable.camasirhane,
            onClick = { navController.navigate("laundry-mgmt/$studentNo") }
        )

        // Kayıp Eşya Kartı
        ActionCard(
            title = "Kayıp Eşya",
            imageRes = R.drawable.kayip_esya,
            onClick = { navController.navigate("lost-mgmt/$studentNo") }
        )

        // Diğer Kartı
        ActionCard(
            title = "Diğer",
            imageRes = R.drawable.diger,
            onClick = { /* Diğer işlemleri buraya bağlayabilirsin */ }
        )
    }
}

// Kızan ActionCard fonksiyonunun tanımı:
@Composable
fun ActionCard(title: String, imageRes: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp) // Yüksekliği tasarıma göre ayarladık
            .padding(vertical = 15.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Görseli arka plana yayıyoruz
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop // Görselin kartın içini tamamen kaplamasını sağlar
            )

            // Görselin üzerindeki yazının okunması için hafif bir karartma ve metin
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 24.dp), // Metni biraz içeriden başlatıyoruz
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black // Tasarıma göre beyaz da yapabilirsin
                )
            }
        }
    }
}
