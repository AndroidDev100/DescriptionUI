package com.example.descriptionui.description.components.selflearning

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.descriptionui.R
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.descriptionui.description.DescriptionText
import com.example.descriptionui.description.model.TopFacultiesListItem
import com.example.descriptionui.theme.*
import com.example.descriptionui.utils.loadPicture
import com.example.descriptionui.viewmodel.DashboardViewModel



@Composable
fun TopFacultiesComposable(dashboardViewModel: DashboardViewModel) {
  val scrollState = rememberScrollState(0)
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp)
  ) {
    TopFacultiesHeader(dashboardViewModel)
    Spacer(modifier = Modifier.height(10.dp))
    Row(
      modifier = Modifier.fillMaxWidth().wrapContentHeight().align(Alignment.CenterHorizontally).horizontalScroll(state = scrollState, enabled = true),
      horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      for(item in dashboardViewModel.getTopFacultiesList()){
        TopFacultiesListItem(topFacultiesListItem = item)
      }
    }
  }
}



@Composable
fun TopFacultiesHeader(dashboardViewModel: DashboardViewModel) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .height(21.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
  ) {
    DescriptionText(
      modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight(), text = dashboardViewModel.getTopFacultiesText(LocalContext.current), fontSize = 16.sp, fontFamily = gilroy_bold, color = Grey_707070, onClick = null
    )
    DescriptionText(
      modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight(), text = dashboardViewModel.getViewAllText(LocalContext.current), fontSize = 16.sp, fontFamily = gilroy_semi_bold, color = Purple500, onClick = dashboardViewModel.onViewAllClick
    )
  }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TopFacultiesListItem(topFacultiesListItem: TopFacultiesListItem) {
  Column(
    modifier = Modifier
      .width(140.dp)
      .height(200.dp)
  ) {
    Surface(
      modifier = Modifier
        .fillMaxWidth()
        .height(140.dp)
        .padding(horizontal = 10.dp)
    ) {
      GlideImage(modifier = Modifier.fillMaxSize(), model = topFacultiesListItem.bannerImageUrl, contentDescription = "")
    }
    Surface(
      modifier = Modifier
        .width(140.dp)
        .height(54.dp)
        .background(color = Grey_F7F7F7, shape = Shapes.medium)
        .padding(horizontal = 8.dp, vertical = 6.dp)
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight()
          .background(color = Grey_F7F7F7)
      ) {
        DescriptionText(
          modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight(), text = topFacultiesListItem.facultyName, fontSize = 12.sp, fontFamily = gilroy_semi_bold, color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), horizontalArrangement = Arrangement.Start
        ) {
          TopFacultyTag(topFacultiesListItem.courseName)
          Spacer(modifier = Modifier.width(6.dp))
          TopFacultyTag(topFacultiesListItem.experience)
        }
      }
    }
  }
}

private @Composable
fun TopFacultyTag(text: String) {
  Surface(
    modifier = Modifier
      .wrapContentSize()
      .background(color = Color.White, shape = Shapes.medium)
      .padding(horizontal = 6.dp, vertical = 3.dp)
  ) {
    DescriptionText(
      modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight(), text = text, fontSize = 9.sp, fontFamily = gilroy_medium, color = Color.Black
    )
  }
}