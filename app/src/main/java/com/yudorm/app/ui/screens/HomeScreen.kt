package com.yudorm.app.ui.screens

import android.widget.Button
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yudorm.app.ui.theme.AppOrange
import com.yudorm.app.ui.viewmodel.LoginViewModel


@Composable
fun HomeScreen(
    loginViewModel: LoginViewModel,
    onIssueButton : () -> Unit
    ){
    val student = loginViewModel.activeStudent


    val welcomeMessage = if (student != null) {
        "ANASAYFAYA HOŞ GELDİN, ${student.firstName} ${student.lastName}!"
    } else {
        "Hata: Oturum Bilgisi Bulunamadı."
    }

    val studentNo =  if (student != null) { student.studentNumber} else { "" }

    Column {

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Column (horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = welcomeMessage)
                Text(text = "Öğrenci No: ${student?.studentNumber ?: "Yükleniyor..."}")
            }
        }

        Button(
            onClick = onIssueButton,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AppOrange),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text("Sorun bildir")
        }

        
    }



}