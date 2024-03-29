package com.route.chatappc39gsat.addRoom

sealed interface AddRoomViewEvent {
    data object Idle : AddRoomViewEvent
    data object NavigateBack : AddRoomViewEvent
}