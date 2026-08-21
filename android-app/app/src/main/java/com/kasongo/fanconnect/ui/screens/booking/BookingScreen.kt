package com.kasongo.fanconnect.ui.screens.booking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun BookingScreen(navController: NavController) {
    val selectedDate = remember { mutableStateOf("") }
    val selectedTime = remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "BOOKING",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }

        item {
            Text(
                text = "Book Private Call",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }

        // Available slots
        item {
            AvailableSlotCard(
                date = "Friday",
                time = "10:00",
                status = "AVAILABLE",
                onBooking = { selectedDate.value = "Friday"; selectedTime.value = "10:00" }
            )
        }

        item {
            AvailableSlotCard(
                date = "Friday",
                time = "10:30",
                status = "AVAILABLE",
                onBooking = { selectedDate.value = "Friday"; selectedTime.value = "10:30" }
            )
        }

        item {
            AvailableSlotCard(
                date = "Friday",
                time = "11:00",
                status = "RESERVED",
                onBooking = {}
            )
        }

        item {
            AvailableSlotCard(
                date = "Friday",
                time = "14:00",
                status = "AVAILABLE",
                onBooking = { selectedDate.value = "Friday"; selectedTime.value = "14:00" }
            )
        }

        if (selectedTime.value.isNotEmpty()) {
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { navController.navigate("profile") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text("RESERVE MY CALL", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun AvailableSlotCard(
    date: String,
    time: String,
    status: String,
    onBooking: () -> Unit
) {
    val isAvailable = status == "AVAILABLE"
    val bgColor = if (isAvailable) MaterialTheme.colorScheme.surface else Color(0xFF4A4A4A)
    val textColor = if (isAvailable) MaterialTheme.colorScheme.onSurface else Color.Gray
    val statusColor = if (isAvailable) Color(0xFF4CAF50) else Color(0xFFFF6B6B)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = bgColor,
                shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
            .padding(bottom = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = date,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
                Text(
                    text = time,
                    fontSize = 12.sp,
                    color = textColor.copy(alpha = 0.7f)
                )
            }
            Box(
                modifier = Modifier
                    .background(
                        color = statusColor,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = status,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            if (isAvailable) {
                Button(
                    onClick = onBooking,
                    modifier = Modifier
                        .width(80.dp)
                        .height(36.dp)
                ) {
                    Text("Book", fontSize = 11.sp)
                }
            }
        }
    }
}
