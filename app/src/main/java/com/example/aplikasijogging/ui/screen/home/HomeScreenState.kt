package com.example.aplikasijogging.ui.screen.home

import com.example.aplikasijogging.data.model.Run
import com.example.aplikasijogging.data.model.User
import com.example.aplikasijogging.domain.model.CurrentRunStateWithCalories

data class HomeScreenState(
    val runList: List<Run> = emptyList(),
    val currentRunStateWithCalories: CurrentRunStateWithCalories = CurrentRunStateWithCalories(),
    val currentRunInfo: Run? = null,
    val user: User = User(),
    val distanceCoveredInKmInThisWeek: Float = 0.0f
)
