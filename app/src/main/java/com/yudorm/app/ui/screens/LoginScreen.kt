package com.yudorm.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yudorm.app.ui.viewmodel.LoginViewModel
import com.yudorm.app.R
import com.yudorm.app.ui.theme.*


@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    onLoginSuccess: (String?) -> Unit,
    onPasswordResetButton: () -> Unit,
    onAuthorityLoginButton: () -> Unit,
    onRegisterButton: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.yudorm_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(250.dp)
        )


        Spacer(modifier = Modifier.height(48.dp))


        Text(
            text = "Öğrenci no",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            color = Color.Black
        )

        OutlinedTextField(
            value = viewModel.studentNo,
            onValueChange = { viewModel.studentNo = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Şifre",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            color = Color.Black
        )

        OutlinedTextField(
            value = viewModel.password,
            onValueChange = { viewModel.password = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            )
        )


        Spacer(modifier = Modifier.height(8.dp))


        Text(
            text = "Şifrenizi mi unuttunuz?",
            color = AppBlue,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.End)
                .clickable { onPasswordResetButton() }
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Kayıtlı değil misiniz? Kayıt ol",
            color = AppBlue,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.End)
                .clickable { onRegisterButton() }
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))


        Button(
            onClick = {
                viewModel.login()
                if (viewModel.message == "Giriş Başarılı!"){
                    onLoginSuccess(viewModel.studentNo)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AppBlue),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(text = "Giriş Yap", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                onRegisterButton()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AppGreen),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(text = "Kayıt Ol", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = { onAuthorityLoginButton},
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AppOrange),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(text = "Yetkili Girişi", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = viewModel.message)
    }
}