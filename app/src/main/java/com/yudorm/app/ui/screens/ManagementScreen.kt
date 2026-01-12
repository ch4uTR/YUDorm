package com.yudorm.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.yudorm.app.R

@Composable
fun ManagementScreen(
    title: String,
    onNewClick: () -> Unit,
    onListClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(title, fontSize = 22.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 32.dp))

        // Yeni Kayıt Oluştur (Resimli Büyük Kart)
        ManagementSelectionCard(
            title = "Yeni Kayıt Oluştur",
            imageRes = R.drawable.kayit_olustur,
            onClick = onNewClick
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Kayıtlarım (Resimli Büyük Kart)
        ManagementSelectionCard(
            title = "Kayıtlarım",
            imageRes = R.drawable.kayitlarim,
            onClick = onListClick
        )
    }
}

@Composable
fun ManagementSelectionCard(title: String, imageRes: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop // Görselin kartı kaplamasını sağlar
            )
            // Metnin okunması için üzerine hafif bir karartma ve yazı:
            Box(
                modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Text(title, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
            }
        }
    }
}


