package com.example.aplikasijogging.ui.screen.onboard

import com.example.aplikasijogging.data.model.Gender


interface OnBoardingScreenEvent {
    fun updateName(name: String)
    fun updateGender(gender: Gender)
    fun updateWeight(weightInKg: Float)
    fun updateWeeklyGoal(weeklyGoalInKm: Float)
}