package com.route.chatappc39gsat.splash

import com.route.chatappc39gsat.model.AppUser

sealed interface SplashEvent {
    data object Idle : SplashEvent
    data object NavigateToLogin : SplashEvent
    data class NavigateToHome(val user: AppUser) : SplashEvent
}