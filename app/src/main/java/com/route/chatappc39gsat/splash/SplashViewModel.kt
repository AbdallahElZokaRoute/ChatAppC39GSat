package com.route.chatappc39gsat.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {
    val event = mutableStateOf<SplashEvent>(SplashEvent.Idle)

    fun navigate() {
        navigateToLogin()

    }

    fun navigateToLogin() {
        event.value = SplashEvent.NavigateToLogin
    }

    fun navigateToHome() {
        event.value = SplashEvent.NavigateToHome
    }
}
