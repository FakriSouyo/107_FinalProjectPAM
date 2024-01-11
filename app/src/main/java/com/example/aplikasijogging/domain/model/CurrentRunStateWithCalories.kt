package com.example.aplikasijogging.domain.model

import com.example.aplikasijogging.tracking.model.CurrentRunState


data class CurrentRunStateWithCalories(
    val currentRunState: CurrentRunState = CurrentRunState(),
    val caloriesBurnt: Int = 0
)