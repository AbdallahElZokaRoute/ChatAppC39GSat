package com.route.chatappc39gsat.splash

sealed interface SplashEvent {
    data object Idle : SplashEvent
    data object NavigateToLogin : SplashEvent
    data object NavigateToHome : SplashEvent
}