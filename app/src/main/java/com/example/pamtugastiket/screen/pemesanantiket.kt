package com.example.pamtugastiket.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.util.Locale

@Composable
fun PemesananTiketScreen() {
    val hargaTiket = 25000

    // State: setiap kali nilai ini berubah, Compose akan recomposition
    var jumlahTiket by remember { mutableStateOf(1) }

    val totalBayar = hargaTiket * jumlahTiket
    val formatRupiah = NumberFormat.getNumberInstance(Locale("in", "ID"))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(12.dp))

        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(48.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Pemesanan Tiket",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Silakan atur jumlah tiket yang ingin dibeli",
            fontSize = 13.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        InfoCard(label = "Harga per Tiket", value = "Rp${formatRupiah.format(hargaTiket)}")

        Spacer(modifier = Modifier.height(16.dp))

        // Kartu Jumlah Tiket (stepper + / -)
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Jumlah Tiket", fontSize = 14.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Event onClick -> mengubah state jumlahTiket, minimal 1
                    StepperButton(
                        icon = Icons.Default.Remove,
                        enabled = jumlahTiket > 1,
                        onClick = { if (jumlahTiket > 1) jumlahTiket-- }
                    )

                    Text(
                        text = jumlahTiket.toString(),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.widthIn(min = 64.dp)
                    )

                    StepperButton(
                        icon = Icons.Default.Add,
                        enabled = true,
                        onClick = { jumlahTiket++ }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Kartu Total Bayar, warna menonjol
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Total Bayar", fontSize = 15.sp, color = Color.White.copy(alpha = 0.85f))
                Text(
                    "Rp${formatRupiah.format(totalBayar)}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        // Event onClick -> reset state ke nilai awal
        OutlinedButton(
            onClick = { jumlahTiket = 1 },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text("Reset")
        }
    }
}

/** Kartu sederhana berisi satu baris label - nilai, dipakai untuk menampilkan Harga per Tiket. */
@Composable
private fun InfoCard(label: String, value: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(label, fontSize = 14.sp, color = Color.Gray)
            Text(value, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}