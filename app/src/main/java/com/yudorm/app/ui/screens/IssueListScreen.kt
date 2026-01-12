package com.yudorm.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IssueListScreen(studentNo: String) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Arıza Kayıtlarım", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        // Bu veriler ileride C# backend'den çekilecek
        val mockIssues = listOf("BORU" to Color.Yellow, "DUVAR" to Color.Green, "YATAK" to Color.Red)

        LazyColumn(modifier = Modifier.fillMaxWidth().padding(top = 16.dp)) {
            items(mockIssues) { issue ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Delete, contentDescription = null, tint = Color.Gray)
                        Text(issue.first, modifier = Modifier.weight(1f).padding(start = 16.dp))
                        Box(modifier = Modifier.size(16.dp).background(issue.second, CircleShape))
                    }
                }
            }
        }
    }
}