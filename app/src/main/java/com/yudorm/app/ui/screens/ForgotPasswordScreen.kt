package com.yudorm.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ForgotPasswordScreen(onBack: () -> Unit) {
    val AppBlue = Color(0xFF2F76BD)
    var isSuccess by remember { mutableStateOf(false) }

    // Form alanları için stateler
    var oldPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Geri Butonu
        Row(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Geri")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Parolayı Güncelle",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Text(
            text = "Lütfen parolanızı yenilemek için yeni bir şifre giriniz.",
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Tasarımdaki giriş alanları
        CustomPasswordInput(label = "Eski Şifre", value = oldPassword, onValueChange = { oldPassword = it })
        CustomPasswordInput(label = "Yeni Şifre", value = newPassword, onValueChange = { newPassword = it })
        CustomPasswordInput(label = "Şifreyi Yeniden Girin", value = confirmPassword, onValueChange = { confirmPassword = it })

        Spacer(modifier = Modifier.height(40.dp))

        // Yenile Butonu
        Button(
            onClick = { isSuccess = true },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AppBlue),
            shape = RoundedCornerShape(25.dp)
        ) {
            Text("Yenile")
        }

        // Başarı Mesajı (Tasarımın altındaki turuncu yazı)
        if (isSuccess) {
            Column(
                modifier = Modifier.padding(top = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Parola Güncellendi", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(
                    text = "Parolanız güncelleme talebiniz başarıyla gerçekleşmiştir.",
                    color = Color(0xFFFFA726), // Turuncu renk
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp)


                )
            }
        }
    }
}

// Şifre alanları için sadeleştirilmiş fonksiyon
@Composable
fun CustomPasswordInput(label: String, value: String, onValueChange: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Text(label, fontWeight = FontWeight.Bold, fontSize = 14.sp, modifier = Modifier.padding(start = 8.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
            shape = RoundedCornerShape(25.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFE0E0E0),
                focusedBorderColor = Color(0xFF2F76BD)
            )
        )
    }
}