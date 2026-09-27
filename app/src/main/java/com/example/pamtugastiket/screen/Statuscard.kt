package com.example.pamtugastiket.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun StatusCard(status: OrderStatus) {
    val (bgColor, textColor, label) = when (status) {
        OrderStatus.IDLE -> Triple(Color(0xFFEFEFEF), Color(0xFF555555), "Silakan pesan tiket")
        OrderStatus.EMPTY_NAME -> Triple(Color(0xFFFDE8E8), Color(0xFFC62828), "Nama harus diisi")
        OrderStatus.PROCESSING -> Triple(Color(0xFFE7ECFB), Color(0xFF6750A4), "Memproses pesanan...")
        OrderStatus.SUCCESS -> Triple(Color(0xFFE3F6E8), Color(0xFF2E7D32), "Tiket berhasil dipesan!")
    }

    Surface(
        color = bgColor,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            when (status) {
                OrderStatus.PROCESSING -> CircularProgressIndicator(
                    color = textColor,
                    strokeWidth = 2.dp,
                    modifier = Modifier.size(18.dp)
                )
                OrderStatus.SUCCESS -> Icon(Icons.Default.CheckCircle, contentDescription = null, tint = textColor, modifier = Modifier.size(20.dp))
                OrderStatus.EMPTY_NAME -> Icon(Icons.Default.Error, contentDescription = null, tint = textColor, modifier = Modifier.size(20.dp))
                OrderStatus.IDLE -> Icon(Icons.Default.Info, contentDescription = null, tint = textColor, modifier = Modifier.size(20.dp))
            }

            Spacer(modifier = Modifier.width(10.dp))

            Text("Status: ", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF333333))
            Text(label, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = textColor)
        }
    }
}