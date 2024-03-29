package com.route.chatappc39gsat.home

sealed interface HomeViewEvent {
    data object Idle : HomeViewEvent
    data object NavigateToAddRoomDestination : HomeViewEvent

}
