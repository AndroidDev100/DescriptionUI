package com.example.descriptionui.description.components.selflearning

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.descriptionui.description.DescriptionText
import com.example.descriptionui.theme.*
import com.example.descriptionui.viewmodel.DashboardViewModel

@Composable
fun WorksheetsCount(dashboardViewModel: DashboardViewModel) {
  Column(modifier = Modifier.wrapContentHeight(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
    WorksheetsText(dashboardViewModel)
    HeaderLabel(text = "Worksheets")
  }
}

@Composable
fun QuizzesCount(dashboardViewModel: DashboardViewModel) {
  Column(modifier = Modifier.wrapContentHeight(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
    QuizzesText(dashboardViewModel)
    HeaderLabel(text = "Quizzes")
  }
}

@Composable
fun QuizzesText(dashboardViewModel: DashboardViewModel) {
  val quizzessCount by dashboardViewModel.getQuizzessCount()!!.observeAsState()
  quizzessCount?.let { DescriptionText(modifier = Modifier.wrapContentSize(), text = quizzessCount!!, fontSize = 16.sp, fontFamily = gilroy_bold, color = Color.Black) }
}

@Composable
fun Seperator() {
  Box(
    modifier = Modifier
      .wrapContentHeight()
      .width(2.dp)
      .background(color = Grey_707070, shape = Shapes.small)
  ){}
}

@Composable
fun RecordedClassesCount(dashboardViewModel: DashboardViewModel) {
  Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceEvenly) {
    RecordedClassesText(dashboardViewModel)
    HeaderLabel(text = "Recorded Classes")
  }
}
@Composable
fun LecturesCountComposable(dashboardViewModel: DashboardViewModel) {
  Column(modifier = Modifier.wrapContentSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
    LecturesCount(dashboardViewModel)
    HeaderLabel(text = "Lectures")
  }
}

@Composable
fun RecordedClassesText(dashboardViewModel: DashboardViewModel) {
  val recordedClasses by dashboardViewModel.getRecordedClasses()!!.observeAsState()
  recordedClasses?.let { DescriptionText(modifier = Modifier.wrapContentSize(), text = recordedClasses!!, fontSize = 16.sp, fontFamily = gilroy_bold, color = Color.Black) }
}
@Composable
fun LecturesCount(dashboardViewModel: DashboardViewModel) {
  val recordedClasses by dashboardViewModel.getRecordedClasses()!!.observeAsState()
  recordedClasses?.let { DescriptionText(modifier = Modifier.wrapContentSize(), text = recordedClasses!!, fontSize = 16.sp, fontFamily = gilroy_bold, color = Color.Black) }
}
@Composable
fun SelfLearningHeader(dashboardViewModel: DashboardViewModel) {
  Column(
    modifier = Modifier
      .fillMaxWidth().wrapContentHeight()
      .padding(horizontal = 20.dp)
  ) {
    DescriptionText(
      modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight(), text = dashboardViewModel.getThisCourseIncludesText(LocalContext.current), fontSize = 16.sp, fontFamily = gilroy_semi_bold, color = Color.Black
    )
    Spacer(modifier = Modifier.height(20.dp))
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .height(53.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
      LecturesCountComposable(dashboardViewModel)
      Seperator()
      QuizzesCount(dashboardViewModel)
      Seperator()
      WorksheetsCount(dashboardViewModel)
    }
  }

}
@Composable
fun WorksheetsText(dashboardViewModel: DashboardViewModel) {
  val worksheets by dashboardViewModel.getWorksheetsCount()!!.observeAsState()
  worksheets?.let { DescriptionText(modifier = Modifier.wrapContentSize(), text = worksheets!!, fontSize = 16.sp, fontFamily = gilroy_bold, color = Color.Black) }

}

@Composable
fun HeaderLabel(text: String) {
  Text(
    modifier = Modifier
      .wrapContentWidth()
      .wrapContentHeight(), text = text, fontSize = 16.sp, fontFamily = gilroy_medium
  )
}
