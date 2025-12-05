package com.yudorm.app.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yudorm.app.ui.viewmodel.LoginViewModel


@Composable
fun HomeScreen(loginViewModel: LoginViewModel = viewModel() ){
    val student = loginViewModel.activeStudent

    val welcomeMessage = if (student != null) {
        "ANASAYFAYA HOŞ GELDİN, ${student.firstName} ${student.lastName}!"
    } else {
        "Hata: Oturum Bilgisi Bulunamadı."
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = welcomeMessage)
            Text(text = "Öğrenci No: ${student?.studentNumber ?: "Yükleniyor..."}")
        }
    }
}