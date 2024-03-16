package com.route.chatappc39gsat.register

import com.route.chatappc39gsat.model.AppUser

sealed interface RegisterEvent {
    data object Idle : RegisterEvent
    data class NavigateToHome(val user: AppUser) : RegisterEvent



}