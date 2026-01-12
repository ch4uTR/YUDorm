package com.yudorm.app.ui.screens



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen(studentNo: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Hafif gri arka plan
            .padding(16.dp)
    ) {
        // Üst Kısım: Geri ve Mesaj İkonu
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Geri")
            Icon(Icons.Default.MailOutline, contentDescription = "Mesajlar")
        }

        // Ana Beyaz Kart
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
                .align(Alignment.Center),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(32.dp))

                // Dil Ayarı Butonu
                SettingsButton(
                    icon = Icons.Default.Language,
                    label = "Dil:",
                    value = "Türkçe"
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Tema Ayarı Butonu
                SettingsButton(
                    icon = Icons.Default.LightMode,
                    label = "Tema:",
                    value = "Açık"
                )

                Spacer(modifier = Modifier.weight(1f))

                // Önbelleği Temizle Butonu
                Button(
                    onClick = { /* Önbellek temizleme mantığı */ },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(55.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F)) // Kırmızı
                ) {
                    Text("Önbelleği Temizle", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun SettingsButton(icon: ImageVector, label: String, value: String) {
    Button(
        onClick = { /* Ayar değiştirme */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)) // Mavi
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(12.dp))
            VerticalDivider(color = Color.White.copy(alpha = 0.5f), modifier = Modifier.padding(vertical = 8.dp))
            Spacer(modifier = Modifier.width(12.dp))
            Text(label, modifier = Modifier.weight(1f), fontSize = 16.sp)
            Text(value, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}