package com.route.chatappc39gsat.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val events = mutableStateOf<HomeViewEvent>(HomeViewEvent.Idle)


    fun navigateToAddRoomScreen() {
        events.value = HomeViewEvent.NavigateToAddRoomDestination
    }

    fun resetToIdleState() {
        events.value = HomeViewEvent.Idle
    }
}
