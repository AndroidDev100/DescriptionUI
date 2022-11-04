package com.example.descriptionui.description.components.selflearning

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.descriptionui.R
import com.example.descriptionui.description.DescriptionText
import com.example.descriptionui.description.model.CourseModel
import com.example.descriptionui.theme.*
import com.example.descriptionui.utils.loadPicture
import com.example.descriptionui.viewmodel.DashboardViewModel

@Composable
fun StartingAtSection(dashboardViewModel: DashboardViewModel) {
  Column(
    modifier = Modifier
      .wrapContentWidth()
      .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally
  ) {
    DescriptionText(modifier = Modifier.wrapContentSize(), text = "Starting at", fontSize = 16.sp, fontFamily = gilroy_regular, color = Black_333333)
    Spacer(modifier = Modifier.height(2.dp))
    DrawableWrapper(drawableStart = R.drawable.ic_pw) {
      Row(
        modifier = Modifier
          .wrapContentHeight()
          .wrapContentWidth()
      ) {
        Text(modifier = Modifier.wrapContentSize(), text = dashboardViewModel.getDescriptionBuyNowFooter().startingprice, fontSize = 16.sp, fontFamily = gilroy_bold, color = Black_333333)
        Spacer(modifier = Modifier.width(5.dp))
        Text(modifier = Modifier.wrapContentSize(), text = dashboardViewModel.getDescriptionBuyNowFooter().originalPrice, fontSize = 16.sp, fontFamily = gilroy_regular, color = Black_333333)
      }
    }
    Spacer(modifier = Modifier.height(2.dp))
    DescriptionText(modifier = Modifier.wrapContentSize(), text = "(For Full Course)", fontSize = 16.sp, fontFamily = gilroy_regular, color = Black_333333)
  }
}

@Composable
fun DiscountTag(dashboardViewModel: DashboardViewModel) {
  Surface(
    modifier = Modifier
      .width(73.dp)
      .height(31.dp)
      .background(color = SuperLightBlue_FAFAFA, shape = Shapes.medium)
  ) {
    DescriptionText(modifier = Modifier.wrapContentSize(), text = dashboardViewModel.getDescriptionBuyNowFooter().discount + " OFF", fontSize = 16.sp, fontFamily = gilroy_medium, color = Green_47B586)
  }
}

@Composable
fun SelfLearningBuyNowFooter(courseModel: CourseModel, dashboardViewModel: DashboardViewModel) {
  Surface(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight()
      .background(color = Color.White, shape = Shapes.small).padding(vertical = 10.dp), elevation = 10.dp
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(horizontal = 15.dp, vertical = 5.dp)
    ) {
      Row(
        modifier = Modifier
          .fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
      ) {
        StartingAtSection(dashboardViewModel)
        DiscountTag(dashboardViewModel = dashboardViewModel)
        BuyNowButton(onClick = dashboardViewModel.onBuyNowClick, courseModel = courseModel)
      }
    }
  }
}

@Composable
fun BuyNowButton(onClick: ((courseModel: CourseModel) -> Unit), courseModel: CourseModel) {
  Box(
    modifier = Modifier
      .width(120.dp)
      .height(48.dp).clickable { onClick(courseModel) }
  ) {
    Surface(modifier = Modifier
      .fillMaxSize()
      .background(color = Purple_7252F7, shape = Shapes.large)) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .wrapContentHeight(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
      ) {
        DescriptionText(modifier = Modifier.wrapContentSize(), text = "Buy Now", fontSize = 19.sp, fontFamily = gilroy_bold, color = Color.White)
        Spacer(modifier = Modifier.width(6.dp))
        Image(
          painter = painterResource(id = R.drawable.arrow_right__white),
          contentDescription = "Andy Rubin",
          modifier = Modifier
            .wrapContentSize()
        )
      }
    }
  }

}