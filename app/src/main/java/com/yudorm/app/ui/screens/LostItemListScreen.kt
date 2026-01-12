package com.yudorm.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Button
@Composable
fun LostItemListScreen(studentNo: String) {
    var showDeleteDialog by remember { mutableStateOf(false) }
    val lostItems = listOf("Altın Kolye", "Gümüş Kolye", "Bronz Kolye")

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Kayıp Eşya Kayıtlarım", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("Oluşturduğunuz kayıp eşya kayıtlarını bu paneli kullanarak görüntüleyebilirsiniz.",
            fontSize = 12.sp, color = Color.Gray)

        Card(
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Kayıp Eşya Listesi", color = Color(0xFF2196F3), fontWeight = FontWeight.Bold)

                lostItems.forEach { item ->
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { showDeleteDialog = true }) {
                            Icon(Icons.Default.Delete, contentDescription = null)
                        }
                        Text(item, modifier = Modifier.weight(1f))
                    }
                    HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
                }
            }
        }

        // Tasarımdaki Özel Silme Onay Kutusu
        if (showDeleteDialog) {
            Card(
                modifier = Modifier.padding(top = 32.dp).fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Silmek İstediğinize Emin misiniz?", color = Color(0xFFFFA726))
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = { showDeleteDialog = false },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF81C784))
                        ) { Text("Evet") }
                        Button(
                            onClick = { showDeleteDialog = false },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE57373))
                        ) { Text("Hayır") }
                    }
                }
            }
        }
    }
}