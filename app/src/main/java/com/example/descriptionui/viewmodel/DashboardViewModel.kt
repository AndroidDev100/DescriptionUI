package com.example.descriptionui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.descriptionui.R
import com.example.descriptionui.description.model.*

class DashboardViewModel : ViewModel() {
  fun getWatchPreviewImageUrl(): String {
    return "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg"
  }

  fun getWatchPreviewText(context: Context): String {
    return context.getString(R.string.watch_preview)
  }

  fun getViewAllText(context: Context): String {
    return context.getString(R.string.view_all)
  }

  fun getTopFacultiesText(context: Context): String {
    return context.getString(R.string.top_faculties)
  }

  fun getDemoVideosDescriptionText(context: Context): String {
    return context.getString(R.string.demo_videos)
  }

  fun getQuizzessCount(): LiveData<String>? {
    quizzessCount.postValue("50+")
    return _quizzessCount
  }

  fun getRecordedClasses(): LiveData<String>? {
    recordedClasses.postValue("100+")
    return _recordedClasses
  }

  fun getWorksheetsCount(): LiveData<String>? {
    worksheetsCount.postValue("20+")
    return _worksheetsCount
  }

  fun getTopFacultiesList(): List<TopFacultiesListItem> {
    return mutableListOf(
      TopFacultiesListItem(bannerImageUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", facultyName = "Rahul Singh", courseName = "B.Tech", experience = "5 yrs"),
      TopFacultiesListItem(bannerImageUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", facultyName = "Rahul Singh", courseName = "B.Tech", experience = "6 yrs"),
      TopFacultiesListItem(bannerImageUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", facultyName = "Rahul Singh", courseName = "B.Tech", experience = "7 yrs"),
      TopFacultiesListItem(bannerImageUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", facultyName = "Rahul Singh", courseName = "B.Tech", experience = "8 yrs")
    )
  }

  fun getThisCourseIncludesText(context: Context): String {
    return context.getString(R.string.this_course_includes)
  }

  fun getDemoVideosDescriptionList(): List<DemoVideosDescriptionItem> {
    return mutableListOf(
      DemoVideosDescriptionItem("https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", "Sachin Sir NCERT Full Form", "NCERT Full Form"),
      DemoVideosDescriptionItem("https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", "Sachin Sir NCERT Full Form", "NCERT Full Form"),
      DemoVideosDescriptionItem("https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", "Sachin Sir NCERT Full Form", "NCERT Full Form"),
      DemoVideosDescriptionItem("https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", "Sachin Sir NCERT Full Form", "NCERT Full Form"),
      DemoVideosDescriptionItem("https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", "Sachin Sir NCERT Full Form", "NCERT Full Form")
    )
  }

  fun getCourseDetailsContentList(): List<CourseDetailsModel> {
    return mutableListOf(
      CourseDetailsModel("This batch is completely free & dedicated to our class 7th students"),
      CourseDetailsModel("Classes will be held on our “PW Little Champs” Youtube Channel"),
      CourseDetailsModel("Classes will be held on our “PW Little Champs” Youtube Channel"),
      CourseDetailsModel("This batch is completely free & dedicated to our class 7th students")
    )
  }

  fun getSelfLearningFAQsList(): List<SelfLearningFAQsItem> {
    return mutableListOf(
      SelfLearningFAQsItem(primaryTitle = "How do I Share my Referral Code?", secondaryTitle = "Just Click on Refer & Earn on Menu of App, Click on the share button"),
      SelfLearningFAQsItem(primaryTitle = "Can PW Money Transfer to Bank?", secondaryTitle = "Just Click on Refer & Earn on Menu of App, Click on the share button"),
      SelfLearningFAQsItem(primaryTitle = "How do I Share my Referral Code?", secondaryTitle = "Just Click on Refer & Earn on Menu of App, Click on the share button"),
      SelfLearningFAQsItem(primaryTitle = "How do I Share my Referral Code?", secondaryTitle = "Just Click on Refer & Earn on Menu of App, Click on the share button"),
      SelfLearningFAQsItem(primaryTitle = "Can PW Money Transfer to Bank?", secondaryTitle = "Just Click on Refer & Earn on Menu of App, Click on the share button"),
      SelfLearningFAQsItem(primaryTitle = "How do I Share my Referral Code?", secondaryTitle = "Just Click on Refer & Earn on Menu of App, Click on the share button")
    )
  }

  fun getDescriptionBuyNowFooter(): DescriptionBuyNowFooterModel {
    return DescriptionBuyNowFooterModel("2999", "3299", "10%")
  }

  var scrollPosition: Int=0
  var courseDetailListScrollPosition:Int=0
  val onBuyNowClick: (courseModel: CourseModel) -> Unit = {

  }
  var onViewAllClick: (() -> Unit)? = {
    //On View All Click
  }
  var onPlayWatchPreviewClick: ((watchPreViewItem:WatchPreviewItem) -> Unit) = {
    //On View All Click
  }
  var onPlayDemoVideoClick: ((item: DemoVideosDescriptionItem) -> Unit?) = {
    //On Demo Video Click
  }
  var recordedClasses = MutableLiveData<String>()
  var _recordedClasses: LiveData<String>? = recordedClasses

  var quizzessCount = MutableLiveData<String>()
  var _quizzessCount: LiveData<String>? = quizzessCount

  var worksheetsCount = MutableLiveData<String>()
  var _worksheetsCount: LiveData<String>? = worksheetsCount

  fun isLoading(): Boolean {
    return true
  }

  fun getWatchPreviewList(): List<WatchPreviewItem> {
    return mutableListOf(
      WatchPreviewItem(bannerUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", videoUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg"),
      WatchPreviewItem(bannerUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", videoUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg"),
      WatchPreviewItem(bannerUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", videoUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg"),
      WatchPreviewItem(bannerUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", videoUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg"),
      WatchPreviewItem(bannerUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", videoUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg"),
      WatchPreviewItem(bannerUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg", videoUrl = "https://thumbs.dreamstime.com/b/mountain-range-nature-landscape-forest-beauty-171919792.jpg")
    )
  }
}