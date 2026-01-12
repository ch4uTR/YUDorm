package com.yudorm.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yudorm.app.ui.viewmodel.LostItemViewModel
import kotlin.reflect.KMutableProperty0


// Not: LostItemViewModel'in içeriği senin IssueViewModel yapında olmalı
// (itemName, itemColor, location, date gibi değişkenler içermeli)

@Composable
fun LostItemFormScreen(
    onBack: () -> Unit,
    viewModel: LostItemViewModel = viewModel(),
    studentNo: String,
    onSuccess: () -> Unit // MainActivity'deki navigasyonu tetikler
) {
    val AppBlue = Color(0xFF2F76BD)
    var isSuccess by remember { mutableStateOf(false) }

    // DÜZELTME: onBack() yerine onSuccess() çağırıyoruz
    if (isSuccess) {
        LaunchedEffect(isSuccess) {
            kotlinx.coroutines.delay(2000)
            onSuccess() // MainActivity içindeki success-screen rotasına gider
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Geri")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Kayıp Eşya Kaydı Oluştur", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Text(text = "Lütfen eşya detaylarını girerek devam ediniz.", color = Color.Gray, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(32.dp))

        // Form Alanları Yapılandırması
        val fields = listOf(
            "Kayıp Eşyanın İsmi" to viewModel::itemName,
            "Kayıp Eşyanın Rengi" to viewModel::itemColor,
            "Kaybedilen Tahmini Konum" to viewModel::location,
            "Kaybedilen Tahmini Tarih" to viewModel::date
        )

        fields.forEach { (label, property) ->
            Text(text = label, modifier = Modifier.fillMaxWidth().padding(start = 8.dp, bottom = 4.dp), fontWeight = FontWeight.Bold, fontSize = 14.sp)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .border(2.dp, if (property.get().isNotEmpty()) AppBlue else Color(0xFFE0E0E0), RoundedCornerShape(24.dp))
                    .clip(RoundedCornerShape(24.dp))
                    .padding(16.dp)
            ) {
                BasicTextField(
                    value = property.get(),
                    onValueChange = { (property as KMutableProperty0<String>).set(it) },
                    textStyle = TextStyle(color = if (property.get().isNotEmpty()) AppBlue else Color.Black, fontWeight = FontWeight.Medium, fontSize = 16.sp),
                    modifier = Modifier.fillMaxWidth(),
                    decorationBox = { innerTextField ->
                        if (property.get().isEmpty()) {
                            Text("Lütfen doldurunuz...", color = Color.Gray.copy(alpha = 0.5f))
                        }
                        innerTextField()
                    }
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        Spacer(modifier = Modifier.height(32.dp))

        androidx.compose.material3.Button(
            onClick = {
                // ViewModel üzerinden gönderim yapıyoruz
                isSuccess = viewModel.submitLostItem(studentNo)
            },
            // Form doluluğunu ViewModel üzerinden kontrol ediyoruz
            enabled = viewModel.itemName.isNotEmpty() && viewModel.location.isNotEmpty(),
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isSuccess) Color(0xFF4CAF50) else AppBlue,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(25.dp)
        ) {
            Text("Gönder")
        }

        if (viewModel.message.isNotEmpty()) {
            Text(
                text = viewModel.message,
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                color = if (isSuccess) Color(0xFF4CAF50) else Color.Red,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium
            )
        }
    }
}