package com.example.descriptionui.description.components.selflearning

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.descriptionui.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.descriptionui.description.DescriptionText
import com.example.descriptionui.theme.Black_444444
import com.example.descriptionui.theme.DarkBlue_423C72
import com.example.descriptionui.theme.Shapes
import com.example.descriptionui.theme.gilroy_semi_bold
import com.example.descriptionui.utils.loadPicture
import com.example.descriptionui.viewmodel.DashboardViewModel

@Composable
fun CourseDetailComposable(dashboardViewModel: DashboardViewModel) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp)
  ) {
    CourseDetailHeader()
    CourseDetailList(dashboardViewModel)
  }
}

@Composable
fun CourseDetailHeader() {
  Column(
    modifier = Modifier
      .height(66.dp)
      .fillMaxWidth()
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth().height(64.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        modifier = Modifier
          .wrapContentWidth()
          .wrapContentHeight()
          .align(Alignment.CenterVertically), color = Color.Black, fontSize = 16.sp, fontFamily = gilroy_semi_bold, text = "Course Details"
      )
      Image(
        painter = painterResource(id = R.drawable.ic_logo_course_details),
        contentDescription = "Andy Rubin",
        modifier = Modifier
          .width(98.dp).height(64.dp)
      )
    }
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(2.dp)
        .background(color = DarkBlue_423C72)
    ) {
    }
  }
}

@Composable
fun CourseDetailList(dashboardViewModel: DashboardViewModel) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentWidth()
      .padding(horizontal = 20.dp, vertical = 20.dp)
  ) {
    for (item in dashboardViewModel.getCourseDetailsContentList()) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .wrapContentHeight()
          .padding(vertical = 8.dp)
      ) {
        Surface(
          modifier = Modifier
            .size(13.dp)
            .background(color = Color.White)
        ) {
          Image(painterResource(id = R.drawable.ic_blue_tick), modifier = Modifier.fillMaxSize(), contentDescription = "")
        }
        Spacer(modifier = Modifier.width(10.dp))
        DescriptionText(
          modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(), text = item.content, fontSize = 14.sp, fontFamily = gilroy_semi_bold, color = Black_444444
        )
      }
    }
  }
}
