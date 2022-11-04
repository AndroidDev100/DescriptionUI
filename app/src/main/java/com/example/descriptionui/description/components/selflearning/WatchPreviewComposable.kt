package com.example.descriptionui.description.components.selflearning

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.descriptionui.R
import com.example.descriptionui.description.DescriptionText
import com.example.descriptionui.description.model.WatchPreviewItem
import com.example.descriptionui.theme.Shapes
import com.example.descriptionui.theme.gilroy_semi_bold
import com.example.descriptionui.viewmodel.DashboardViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BackgroundImageWatchPreview(watchPreviewItem: WatchPreviewItem) {
  Surface(modifier = Modifier.fillMaxSize(), shape = Shapes.large) {
    GlideImage(alpha = .5f, contentScale = ContentScale.Fit, modifier = Modifier.fillMaxSize(), model = watchPreviewItem.bannerUrl, contentDescription = "")
  }
}
@Composable
fun WatchPreviewItem(dashboardViewModel: DashboardViewModel, watchPreviewItem: WatchPreviewItem) {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .height(150.dp), contentAlignment = Alignment.Center
  ) {
    BackgroundImageWatchPreview(watchPreviewItem)
    PlayWatchPreviewButton(dashboardViewModel, watchPreviewItem)
  }

}
@Composable
fun WatchPreviewComposable(dashboardViewModel: DashboardViewModel) {
  val scrollState = rememberScrollState(0)
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .padding(horizontal = 20.dp).horizontalScroll(state=scrollState, enabled = true), horizontalArrangement = Arrangement.spacedBy(5.dp)
  ) {
    for(item in dashboardViewModel.getWatchPreviewList()){
      WatchPreviewItem(dashboardViewModel = dashboardViewModel, watchPreviewItem = item)
    }
  }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun PlayWatchPreviewButton(dashboardViewModel: DashboardViewModel, watchPreviewItem: WatchPreviewItem) {
  Surface(
    modifier = Modifier
      .width(129.dp)
      .height(26.dp)
      .background(color = Color.White, shape = Shapes.medium)
      .padding(6.dp)
      .clickable { dashboardViewModel.onPlayWatchPreviewClick(watchPreviewItem) }
  ) {
    Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
      Image(
        painter = painterResource(id = R.drawable.ic_play_purple),
        contentDescription = "Andy Rubin",
        modifier = Modifier
          .wrapContentSize()
      )
      Spacer(modifier = Modifier.width(10.dp))
      DescriptionText(modifier = Modifier.wrapContentSize(), text = dashboardViewModel.getWatchPreviewText(LocalContext.current), fontSize = 11.sp, fontFamily = gilroy_semi_bold, color = Color.Black, onClick = null)
    }
  }
}