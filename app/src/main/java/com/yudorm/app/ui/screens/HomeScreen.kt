package com.yudorm.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yudorm.app.R
import com.yudorm.app.ui.viewmodel.LoginViewModel

@Composable
fun HomeScreen(loginViewModel: LoginViewModel, onIssueButton: () -> Unit) {
    var selectedTab by remember { mutableStateOf("Şikayetler") }
    val AppBlue = Color(0xFF2F76BD)

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        // Üst Kısım: Logo ve İllüstrasyon (Tasarındaki gibi)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(AppBlue)
                .padding(16.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.yudorm_logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(250.dp)
                        .align(Alignment.CenterHorizontally)
                        .fillMaxSize()
                )
            }
        }

        // Tab Seçici (Şikayetler - Duyurular)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TabItem("Şikayetler", selectedTab == "Şikayetler") { selectedTab = "Şikayetler" }
            TabItem("Duyurular", selectedTab == "Duyurular") { selectedTab = "Duyurular" }
        }

        // Liste Alanı
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(Color(0xFFF5F5F5))
                .padding(16.dp)
        ) {
            if (selectedTab == "Şikayetler") {
                ComplaintItem("10. Katta su sebili kırıldı", "Ayhan Abi", 999)
                ComplaintItem("9. Katta yere su döküldü", "Sedat Can Tuncalı", 50)
                ComplaintItem("3. Kat mama kabı boş", "Ayhan Abi", 15)
            } else {
                AnnouncementItem("Su Kesintisi 3 Gün Sürecek")
                AnnouncementItem("Kargolarınızı Lütfen Elden Alın")
                AnnouncementItem("Yurtta Alarm Denemesi Yapılacak")
            }
        }
    }
}

@Composable
fun ComplaintItem(title: String, user: String, votes: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, fontWeight = FontWeight.Bold, color = Color.Black)
            Text(text = user, fontSize = 12.sp, color = Color.Gray)
        }
        // Oylama Kısmı
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.KeyboardArrowUp, contentDescription = null, tint = Color(0xFFFFA726))
            Text(text = votes.toString(), fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
    }
}

// Duyuru satırı şablonu
@Composable
fun AnnouncementItem(text: String) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 12.dp)) {
        Text(text = text, fontSize = 15.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(thickness = 0.5.dp, color = Color.LightGray)
    }
}
@Composable
fun TabItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClick) // Kotlin basic component
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) Color(0xFFFFA726) else Color.Gray // Turuncu seçili renk
        )

        if (isSelected) {
            // Seçili olduğunda altına küçük bir çizgi çekiyoruz
            Box(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .width(40.dp)
                    .height(3.dp)
                    .background(Color(0xFFFFA726), RoundedCornerShape(2.dp))
            )
        }
    }
}