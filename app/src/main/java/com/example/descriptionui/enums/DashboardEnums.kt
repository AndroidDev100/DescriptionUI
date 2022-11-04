package com.example.descriptionui

enum class DashboardFragmentType(var id: Int, var title: String) {
    ;
    companion object {
        fun findByName(name: String?): DashboardFragmentType? = values().firstOrNull { it.name == name }
    }
}