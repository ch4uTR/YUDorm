package com.yudorm.app.ui.screens

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yudorm.app.ui.theme.AppGreen
import com.yudorm.app.ui.viewmodel.IssueViewModel
@Composable
fun IssueScreen(
    studentNo: String,
    viewModel: IssueViewModel = viewModel(),
    onSubmissionSuccess: () -> Unit) {

    val AppBlue = Color(0xFF2F76BD)
    var isSuccess by remember { mutableStateOf(false) }


    if (isSuccess) {
        LaunchedEffect(isSuccess) {
            kotlinx.coroutines.delay(4000)
            onSubmissionSuccess()
        }
    }

    if (!isSuccess){

    }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(36.dp))

            Text(
                text = "Arıza Kaydı Oluştur",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp

            )
            Text(
                text = "Lütfen oluşturmak istediğiniz arıza kaydını seçiniz",
                textAlign = TextAlign.Center,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(36.dp))
3
            if (!isSuccess){

                val categories = listOf(
                    "Buzdolabı",
                    "Elektrik Altyapısı",
                    "Internet",
                    "Kalorifer",
                    "Tuvalet/Banyo Tesisatı",
                    "Dolap/Masa/Yatak",
                    "Diğer"
                )
                categories.forEach { category ->
                    val isSelected = viewModel.activeCategory == category
                    val isOther = category == "Diğer"
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .border(2.dp, if (isSelected) AppBlue else Color(0xFFE0E0E0), RoundedCornerShape(24.dp))
                            .clip(RoundedCornerShape(24.dp))
                            .clickable { viewModel.activeCategory = category }
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        if (isOther && isSelected) {
                            BasicTextField(
                                value = viewModel.otherDetails,
                                onValueChange = { viewModel.otherDetails = it },
                                textStyle = TextStyle(
                                    color = AppBlue,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                ),
                                modifier = Modifier.fillMaxWidth(),
                                decorationBox = { innerTextField ->
                                    if (viewModel.otherDetails.isEmpty()) {
                                        Text("Detay giriniz...", color = AppBlue.copy(alpha = 0.5f))
                                    }
                                    innerTextField()
                                }
                            )
                        } else {
                            Text(
                                text = if (isOther && viewModel.otherDetails.isNotEmpty()) viewModel.otherDetails else category,
                                color = if (isSelected) AppBlue else Color.Black,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(36.dp))

                androidx.compose.material3.Button(
                    onClick = {
                        isSuccess = viewModel.submitIssue(studentNo)
                    },
                    enabled = viewModel.activeCategory.isNotEmpty(),
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSuccess) Color(0xFF4CAF50) else AppBlue,
                        contentColor = Color.White,
                        disabledContainerColor = Color.LightGray
                    )
                ) {
                    Text("Gönder")
                }

                if (viewModel.message.isNotEmpty()) {
                    Text(
                        text = viewModel.message,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        color = if (isSuccess) Color(0xFF4CAF50) else Color.Red,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            else{

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(40.dp))


                    Image(
                        painter = painterResource(com.yudorm.app.R.drawable.ariza_kaydi_alindi),
                        contentDescription = "Ariza Kaydi Alındı",
                        modifier = Modifier
                            .size(200.dp)
                            .padding(bottom = 24.dp),
                        contentScale = ContentScale.Fit
                    )


                    Text(
                        text = "Arıza Kaydı Oluşturuldu",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))


                    Text(
                        text = "Arıza kaydı talebiniz yetkili personele\ngönderilmiştir",
                        fontSize = 16.sp,
                        color = Color(0xFFE99C5D),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 32.dp)
                    )
                }

            }

        }



    }


