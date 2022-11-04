package com.example.descriptionui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.descriptionui.theme.gilroy_medium
import com.example.descriptionui.theme.gilroy_semi_bold

// Set of Material typography styles to start with
val Typography = Typography(
  body1 = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
  ),
  body2 = TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Bold, fontSize = 11.sp)
)

val self_learning_description_header_body = TextStyle(fontFamily = gilroy_medium, fontWeight = FontWeight.Normal, fontSize = 11.sp)
val self_learning_description_header = TextStyle(fontFamily = gilroy_semi_bold, fontWeight = FontWeight.Normal, fontSize = 16.sp)
