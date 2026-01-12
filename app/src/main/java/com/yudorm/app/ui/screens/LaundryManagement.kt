package com.yudorm.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LaundryScreen(status: String = "NOT_READY") { // "READY", "NOT_FOUND" gibi durumlar gelebilir
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Çamaşırhane Kayıtları", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("Çamaşırhane ve çamaşır bilgilerine bu paneli kullanarak ulaşabilirsiniz.",
            textAlign = TextAlign.Center, color = Color.Gray, fontSize = 12.sp)

        Spacer(modifier = Modifier.height(80.dp))

        // Oda No
        Text("E915", fontSize = 100.sp, fontWeight = FontWeight.Black)

        Spacer(modifier = Modifier.height(40.dp))

        // Durum Butonu
        val (btnColor, btnText) = when(status) {
            "READY" -> Color(0xFF4CAF50) to "ÇAMAŞIRLARINIZ HAZIR"
            "NOT_READY" -> Color(0xFFFFA726) to "ÇAMAŞIRLARINIZ HAZIR DEĞİL"
            else -> Color.LightGray to "ÇAMAŞIR VERİSİ BULUNAMADI"
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = btnColor),
            modifier = Modifier.fillMaxWidth().height(55.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(btnText, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(60.dp))

        // Doluluk Oranı
        Text("Çamaşırhane Doluluk Oranı", fontSize = 14.sp)
        LinearProgressIndicator(
            progress = 0.6f, // %60 doluluk
            modifier = Modifier.fillMaxWidth().height(24.dp).clip(RoundedCornerShape(12.dp)),
            color = Color.Red,
            trackColor = Color(0xFFE0E0E0)
        )
    }
}