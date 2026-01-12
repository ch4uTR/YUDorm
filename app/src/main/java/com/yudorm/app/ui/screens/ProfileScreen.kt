package com.yudorm.app.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
@Composable
fun ProfileScreen(studentNo: String) {
    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        // Arka plandaki o ince illüstrasyon (Opsiyonel)
        // Image(painterResource(R.drawable.top_illustration), ...)

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
                .align(Alignment.Center)
                .padding(20.dp),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF2196F3)),
            elevation = CardDefaults.cardElevation(12.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Köpekli Profil Resmi (Senin paylaştığın görseldeki gibi)
                Surface(
                    modifier = Modifier.size(160.dp),
                    shape = CircleShape,
                    border = BorderStroke(2.dp, Color.White)
                ) {
                    // Buraya R.drawable.profile_dog gibi bir resim koyabilirsin
                    Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(100.dp))
                }

                Text("Ayhan Abi", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 12.dp))

                Spacer(modifier = Modifier.height(30.dp))

                // Bilgi Satırları
                ProfileDetailRow("Okul No:", studentNo)
                ProfileDetailRow("Departman:", "Görsel İletişim Tasarımı")
                ProfileDetailRow("Oda Numarası:", "C1009")

                Spacer(modifier = Modifier.weight(1f))

                // Alt Butonlar
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(
                        onClick = {},
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.2f)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Parolayı Güncelle", fontSize = 12.sp)
                    }
                    Button(
                        onClick = {},
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F)), // Kırmızı çıkış butonu
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Çıkış Yap", fontSize = 12.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileDetailRow(label: String, value: String) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(label, color = Color.White, fontSize = 14.sp)
            Text(value, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
        Divider(color = Color.White.copy(alpha = 0.6f), thickness = 1.dp)
    }
}

@Composable
fun ProfileRow(label: String, value: String) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(label, color = Color.White.copy(0.8f))
            Text(value, color = Color.White, fontWeight = FontWeight.Medium)
        }
        Divider(color = Color.White.copy(0.3f), thickness = 1.dp)
    }
}