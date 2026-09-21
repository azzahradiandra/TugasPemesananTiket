package com.example.pamtugastiket.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun StepperButton(
    icon: ImageVector,
    enabled: Boolean,
    onClick: () -> Unit
) {
    val bgColor = if (enabled) MaterialTheme.colorScheme.primary else Color(0xFFE0E0E0)
    val iconColor = if (enabled) Color.White else Color.Gray

    Box(
        modifier = Modifier
            .size(44.dp)
            .clip(CircleShape)
            .background(bgColor),
        contentAlignment = Alignment.Center
    ) {
        IconButton(onClick = onClick, enabled = enabled) {
            Icon(icon, contentDescription = null, tint = iconColor)
        }
    }
}