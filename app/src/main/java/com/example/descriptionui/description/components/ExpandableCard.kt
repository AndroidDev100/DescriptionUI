package com.example.descriptionui.description.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ContentAlpha.medium
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.descriptionui.theme.Shapes
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.descriptionui.theme.BlueLight_F0F4FA
import com.example.descriptionui.theme.SuperLightBlue_F0F4FA
import com.example.descriptionui.theme.SuperLightBlue_FAFAFA

@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
  title: String,
  titleFontSize: TextUnit = MaterialTheme.typography.h6.fontSize,
  titleFontWeight: FontWeight = FontWeight.Bold,
  description: String,
  descriptionFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
  descriptionFontWeight: FontWeight = FontWeight.Normal,
  descriptionMaxLines: Int = 4,
  padding: Dp = 5.dp
) {
  var expandedState by remember { mutableStateOf(false) }
  val rotationState by animateFloatAsState(
    targetValue = if (expandedState) 180f else 0f
  )
  Box(modifier = Modifier
    .fillMaxWidth()){
    Surface(
      modifier = Modifier
        .fillMaxWidth()
        .animateContentSize(
          animationSpec = tween(
            durationMillis = 300,
            easing = LinearOutSlowInEasing
          )
        )
        .background(color = SuperLightBlue_F0F4FA, shape = Shapes.medium),
      onClick = {
        expandedState = !expandedState
      }
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(padding)
      ) {
        Surface(modifier= Modifier
          .fillMaxWidth()
          .wrapContentWidth()
          .background(color = BlueLight_F0F4FA, shape = Shapes.large)) {
          Row(
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              modifier = Modifier
                .weight(6f),
              text = title,
              fontSize = titleFontSize,
              fontWeight = titleFontWeight,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
            IconButton(
              modifier = Modifier
                .weight(1f)
                .alpha(ContentAlpha.medium)
                .rotate(rotationState),
              onClick = {
                expandedState = !expandedState
              }) {
              Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Drop-Down Arrow"
              )
            }
          }
        }
        if (expandedState) {
          Box(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(vertical = 20.dp, horizontal = 10.dp)
            .background(color = SuperLightBlue_FAFAFA, shape = Shapes.large) ){
            Surface(modifier = Modifier.fillMaxSize()) {
              Text(
                text = description,
                fontSize = descriptionFontSize,
                fontWeight = descriptionFontWeight,
                maxLines = descriptionMaxLines,
                overflow = TextOverflow.Ellipsis
              )
            }
          }
        }
      }
    }
  }
}