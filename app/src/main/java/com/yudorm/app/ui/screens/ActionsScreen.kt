package com.yudorm.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.yudorm.app.R
import com.yudorm.app.ui.theme.Typography


@Composable
fun ActionsScreen(
    studentNo: String,
    navController: NavController
){

    Column(
        modifier =  Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 90.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ){


        ImageActionButton(
            title = "Arıza Kaydı",
            imgRes = R.drawable.ariza_kaydi,
            onClick = { navController.navigate("issue-management/$studentNo")}
        )

        ImageActionButton(
            title = "Çamaşırhane",
            imgRes = R.drawable.camasirhane,
            onClick = { }
        )

        ImageActionButton(
            title = "Kayıp Eşya",
            imgRes = R.drawable.kayip_esya,
            onClick = { }
        )

        ImageActionButton(
            title = "Diğer",
            imgRes = R.drawable.diger,
            onClick = { }
        )


    }

}








@Composable
fun ImageActionButton(
    title: String,
    imgRes: Int,
    height: Int = 118,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .width(363.dp)
            .height(height.dp)
            .padding(vertical = 10.dp)
            .clickable{ onClick()  },
            shape = RoundedCornerShape(23.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)

    ) {

        Box(){
            Image(
                painter = painterResource(id = imgRes),
                contentDescription = title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 24.dp)
            )
        }

    }



}


@Composable
fun IssueManagementScreen(
    studentNo: String,
    navController: NavController
){

    Column(
        modifier =  Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 90.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ){
        Text(
            text = "Arıza Kayıtları",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Arıza kayıtlarını kontrol etmek ve yeni bir arıza kaydı oluşturmak için lütfen devam edin.",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        ImageActionButton(
            title = "Yeni Kayıt Oluştur",
            imgRes = R.drawable.kayit_olustur,
            onClick = { navController.navigate("submit-issue/$studentNo") },
            height = 187
        )

        ImageActionButton(
            title = "Arıza Kayıtlarım",
            imgRes = R.drawable.kayitlarim,
            onClick = { },
            height = 187
        )
    }

}
