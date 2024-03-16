package com.route.chatappc39gsat.login

import com.route.chatappc39gsat.model.AppUser

sealed interface LoginEvent {
    data object Idle : LoginEvent
    data object NavigateToRegister : LoginEvent
    data class NavigateToHome(val user: AppUser) : LoginEvent
}
