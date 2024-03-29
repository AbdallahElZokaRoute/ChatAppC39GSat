package com.route.chatappc39gsat.splash

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.route.chatappc39gsat.FirebaseUtils
import com.route.chatappc39gsat.model.AppUser

class SplashViewModel : ViewModel() {
    val event = mutableStateOf<SplashEvent>(SplashEvent.Idle)
    val auth = Firebase.auth
    fun navigate() {
        if (auth.currentUser != null) {
            getUserFromFirestore(auth.currentUser?.uid ?: run {
                navigateToLogin()
                return
            })
        } else {
            navigateToLogin()
        }
    }

    fun getUserFromFirestore(uid: String) {
        FirebaseUtils.getUser(uid, onSuccessListener = { docSnapshot ->
            val user = docSnapshot.toObject(AppUser::class.java)
            navigateToHome(user!!)
        }, onFailureListener = {
            Log.e("TAG", "getUserFromFirestore: ${it.message}")
            navigateToLogin()
        })
    }


    fun navigateToLogin() {
        event.value = SplashEvent.NavigateToLogin
    }

    fun navigateToHome(user: AppUser) {
        event.value = SplashEvent.NavigateToHome(user)
    }
}
