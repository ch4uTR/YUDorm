package com.yudorm.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yudorm.app.R
import androidx.compose.material3.Button


@Composable
fun IssueSuccessScreen(
    message: String, // "Arıza Kaydı" veya "Kayıp Eşya Kaydı" gibi metinler gelecek
    onNavigateHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Penguen görselin
        Image(
            painter = painterResource(id = R.drawable.ariza_kaydi_alindi),
            contentDescription = "Başarılı",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "$message Oluşturuldu", // Gelen parametreye göre şekilleniyor
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Talebiniz yetkili personele başarıyla gönderilmiştir.",
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            color = Color(0xFFFFA726),
            modifier = Modifier.padding(top = 8.dp, bottom = 48.dp)
        )

        Button(
            onClick = onNavigateHome,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2F76BD)),
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier.fillMaxWidth(0.7f).height(50.dp)
        ) {
            Text("Ana Sayfaya Dön")
        }
    }
}