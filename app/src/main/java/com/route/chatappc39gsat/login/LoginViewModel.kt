package com.route.chatappc39gsat.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.route.chatappc39gsat.FirebaseUtils
import com.route.chatappc39gsat.model.AppUser

class LoginViewModel : ViewModel() {
    val emailState = mutableStateOf("")
    val emailErrorState = mutableStateOf<String?>(null)
    val passwordState = mutableStateOf("")
    val passwordErrorState = mutableStateOf<String?>(null)
    val isLoading = mutableStateOf(false)
    val events = mutableStateOf<LoginEvent>(LoginEvent.Idle)
    val auth = Firebase.auth
    fun login() {
        if (validateFields()) {
            // Login
            isLoading.value = true
            auth.signInWithEmailAndPassword(emailState.value, passwordState.value)
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        isLoading.value = false
                        Log.e("TAG", "error -> ${task.exception?.message}")
                        return@addOnCompleteListener
                    }
                    val uid = task.result.user?.uid
                    // get User from Firestore
                    getUserFromFirestore(uid!!)
                }

        }
    }

    private fun getUserFromFirestore(uid: String) {
        FirebaseUtils.getUser(uid, onSuccessListener = { documentSnapshot ->
            isLoading.value = false
            val user = documentSnapshot.toObject(AppUser::class.java)
            navigateToHome(user!!)
        }, onFailureListener = {
            isLoading.value = false
        })
    }

    fun validateFields(): Boolean {
        if (emailState.value.isEmpty() && emailState.value.isBlank()) {
            emailErrorState.value = "Required"
            return false
        } else {
            emailErrorState.value = null
        }
        if (passwordState.value.isEmpty() && passwordState.value.isBlank()) {
            passwordErrorState.value = "Required"
            return false
        } else {
            passwordErrorState.value = null
        }
        if (passwordState.value.length < 6) {
            passwordErrorState.value = "Password can't be less that 6 Chars or numbers"
            return false
        } else {
            passwordErrorState.value = null
        }
        return true
    }

    fun navigateToRegister() {
        events.value = LoginEvent.NavigateToRegister
    }

    fun navigateToHome(user: AppUser) {
        events.value = LoginEvent.NavigateToHome(user)
    }

    fun resetEvent() {
        events.value = LoginEvent.Idle
    }

}
