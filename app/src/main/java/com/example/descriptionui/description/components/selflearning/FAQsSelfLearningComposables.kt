package com.example.descriptionui.description.components.selflearning

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.descriptionui.description.components.ExpandableCard
import com.example.descriptionui.theme.gilroy_semi_bold
import com.example.descriptionui.viewmodel.DashboardViewModel

@Composable
fun SelfLearningFAQsHeader(){
  Row(
    modifier = Modifier
      .fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight()
        .align(Alignment.CenterVertically), color = Color.Black, fontSize = 16.sp, fontFamily = gilroy_semi_bold, text = "FAQs"
    )
  }
}
@Composable
fun FAQsSelfLearningDescription(dashboardViewModel: DashboardViewModel) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .padding(horizontal = 20.dp, vertical = 20.dp)
  ) {
    SelfLearningFAQsHeader()
    SelfLearningFAQsList(dashboardViewModel)
  }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelfLearningFAQsList(dashboardViewModel: DashboardViewModel){
  Column(modifier = Modifier
    .fillMaxWidth()
    .wrapContentHeight()){
    for(item in dashboardViewModel.getSelfLearningFAQsList()){
      ExpandableCard(titleFontSize = 14.sp, descriptionFontSize = 14.sp, title = item.primaryTitle, description = item.secondaryTitle)
    }
  }
}