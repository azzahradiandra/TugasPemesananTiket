package com.example.pamtugastiket.screen

enum class OrderStatus {
    IDLE,        // Status: Silakan pesan tiket
    EMPTY_NAME,  // Status: Nama masih kosong
    PROCESSING,  // Status: Memproses pesanan...
    SUCCESS      // Status: Tiket telah dipesan
}