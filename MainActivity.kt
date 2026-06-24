package com.autotasleek

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.autotasleek.ui.theme.AutoTasleekTheme
import com.autotasleek.ui.theme.NeonGreen
import com.autotasleek.ui.theme.DarkGrey

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AutoTasleekTheme {
                MainScreen(onEnableClick = { requestAccessibilityPermission() })
            }
        }
    }

    private fun requestAccessibilityPermission() {
        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        startActivity(intent)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(onEnableClick: () -> Unit) {
    var speed by remember { mutableStateOf(50f) }
    var repeatCount by remember { mutableStateOf("10") }
    var messageText by remember { mutableStateOf("Auto Tasleek Active!") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = DarkGrey
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "AUTO TASLEEK",
                color = NeonGreen,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 40.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = messageText,
                onValueChange = { messageText = it },
                label = { Text("Message to Send", color = NeonGreen) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = NeonGreen,
                    unfocusedBorderColor = Color.Gray,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Speed: ${speed.toInt()} ms",
                    color = NeonGreen,
                    fontWeight = FontWeight.Medium
                )
                Slider(
                    value = speed,
                    onValueChange = { speed = it },
                    valueRange = 3f..350f,
                    colors = SliderDefaults.colors(
                        thumbColor = NeonGreen,
                        activeTrackColor = NeonGreen
                    )
                )
            }

            OutlinedTextField(
                value = repeatCount,
                onValueChange = { repeatCount = it },
                label = { Text("Repeat Count", color = NeonGreen) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = NeonGreen,
                    unfocusedBorderColor = Color.Gray,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onEnableClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = NeonGreen),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    "ENABLE ACCESSIBILITY",
                    color = DarkGrey,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
            
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
