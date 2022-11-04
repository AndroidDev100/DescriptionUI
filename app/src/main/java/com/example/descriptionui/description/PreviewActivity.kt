package com.example.descriptionui.description

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.descriptionui.description.components.selflearning.*
import com.example.descriptionui.description.model.CourseModel
import com.example.descriptionui.theme.PenpencilAndroidAppTheme
import com.example.descriptionui.viewmodel.DashboardViewModel

class PreviewActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      PreviewDescription()
    }
  }

  @Preview(showBackground = true, showSystemUi = false)
  @Composable
  fun PreviewDescription(dashboardViewModel: DashboardViewModel = viewModel()) {
    PenpencilAndroidAppTheme(content = { DescriptionContent(dashboardViewModel) }, displayProgressBar = false)
  }

}

@Composable
fun DescriptionContent(dashboardViewModel: DashboardViewModel) {
  val scrollState = rememberScrollState(0)
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight()
      .verticalScroll(state = scrollState, enabled = true), horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Spacer(modifier = Modifier.height(20.dp))
    SelfLearningHeader(dashboardViewModel = dashboardViewModel)
    Spacer(modifier = Modifier.height(20.dp))
    WatchPreviewComposable(dashboardViewModel = dashboardViewModel)
    Spacer(modifier = Modifier.height(25.dp))
    TopFacultiesComposable(dashboardViewModel = dashboardViewModel)
    Spacer(modifier = Modifier.height(25.dp))
    DemoVideosComposable(dashboardViewModel = dashboardViewModel)
    Spacer(modifier = Modifier.height(25.dp))
    CourseDetailComposable(dashboardViewModel = dashboardViewModel)
    FAQsSelfLearningDescription(dashboardViewModel = dashboardViewModel)
    SelfLearningBuyNowFooter(courseModel = CourseModel(id = "ABC123"), dashboardViewModel = dashboardViewModel)
  }
}

@Composable
fun DescriptionText(modifier: Modifier, text: String, fontSize: TextUnit, fontFamily: FontFamily?, color: Color, onClick: (() -> Unit)? = null) {
  Text(modifier = modifier, color = color, fontSize = fontSize, fontFamily = fontFamily, text = text)
}

@Composable
fun PersistedScrollState(dashboardViewModel: DashboardViewModel, scrollPosition: Int): ScrollState {
  val scrollState = rememberScrollState(scrollPosition)
  DisposableEffect(key1 = null) {
    onDispose {
      dashboardViewModel.scrollPosition = scrollState.value
    }
  }
  return scrollState
}
