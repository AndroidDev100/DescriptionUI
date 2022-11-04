package com.example.descriptionui.description.components.selflearning

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.descriptionui.R
import com.example.descriptionui.description.DescriptionText
import com.example.descriptionui.description.model.DemoVideosDescriptionItem
import com.example.descriptionui.theme.*
import com.example.descriptionui.utils.loadPicture
import com.example.descriptionui.viewmodel.DashboardViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DemoVideosDescriptionItemView(onClick: (item: DemoVideosDescriptionItem) -> Unit?, demoVideosDescriptionItem: DemoVideosDescriptionItem) {
  Surface(
    modifier = Modifier
      .width(151.dp)
      .wrapContentHeight()
      .background(color = Color.White, shape = Shapes.medium), elevation = 10.dp
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
    ) {
      Surface(
        modifier = Modifier
          .width(151.dp)
          .height(75.dp)
          .background(shape = Shapes.medium, color = Color.White)
      ) {
        Box(modifier = Modifier.fillMaxSize()) {
          Surface(
            modifier = Modifier.fillMaxSize()
          ) {
            GlideImage(contentScale = ContentScale.Fit, modifier = Modifier.fillMaxSize(), model = demoVideosDescriptionItem.bannerImageUrl, contentDescription = "")
          }
//          Surface(
//            modifier = Modifier
//              .size(21.dp)
//              .align(alignment = Alignment.Center)
//              .clickable { onClick.invoke(demoVideosDescriptionItem) }
//          ) {
//            Image(painterResource(id = R.drawable.ic_play_white), modifier = Modifier
//              .fillMaxSize()
//              .background(color = Color.Transparent), contentDescription = "")
//          }
        }
      }
      Spacer(modifier = Modifier.height(8.dp))
      LinearProgressIndicator(
        progress = 0.7f, modifier = Modifier
          .fillMaxWidth()
          .height(4.dp)
          .background(color = Purple200, shape = Shapes.small), color = Purple500, backgroundColor = Purple200
      )
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .height(25.dp)
          .padding(horizontal = 7.dp, vertical = 5.dp), horizontalArrangement = Arrangement.spacedBy(5.dp), verticalAlignment = Alignment.CenterVertically
      ) {
        DescriptionText(
          modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth(), text = demoVideosDescriptionItem.primaryTitle, fontSize = 10.sp, fontFamily = gilroy_semi_bold, color = Color.Black
        )
        Box(
          modifier = Modifier
            .width(2.dp)
            .height(10.dp)
            .background(color = Color.Black, shape = Shapes.small)
        ) {
        }
      }
      DescriptionText(
        modifier = Modifier
          .wrapContentHeight()
          .wrapContentWidth()
          .padding(horizontal = 7.dp), text = demoVideosDescriptionItem.secondaryTitle, fontSize = 10.sp, fontFamily = gilroy_semi_bold, color = Color.Black
      )
      Spacer(modifier = Modifier.height(5.dp))
    }
  }
}

@Composable
fun DemoVideosHeader(dashboardViewModel: DashboardViewModel) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .height(21.dp), verticalAlignment = Alignment.CenterVertically
  ) {
    DescriptionText(
      modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight(), text = dashboardViewModel.getDemoVideosDescriptionText(LocalContext.current), fontSize = 16.sp, fontFamily = gilroy_semi_bold, color = Grey_707070, onClick = null
    )
  }
}

@Composable
fun DemoVideosComposable(dashboardViewModel: DashboardViewModel) {
  val scrollState = rememberScrollState(0)
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp)
  ) {
    DemoVideosHeader(dashboardViewModel)
    Spacer(modifier = Modifier.height(15.dp))
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .align(Alignment.CenterHorizontally)
        .horizontalScroll(state = scrollState, enabled = true),
      horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      for (item in dashboardViewModel.getDemoVideosDescriptionList()) {
        DemoVideosDescriptionItemView(onClick = dashboardViewModel.onPlayDemoVideoClick, demoVideosDescriptionItem = item)
      }
    }
  }
}