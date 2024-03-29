package com.route.chatappc39gsat.register

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.route.chatappc39gsat.FirebaseUtils
import com.route.chatappc39gsat.model.AppUser

class RegisterViewModel : ViewModel() {
    val firstNameState = mutableStateOf("")
    val firstNameErrorState = mutableStateOf<String?>(null)
    val emailState = mutableStateOf("")
    val emailErrorState = mutableStateOf<String?>(null)
    val passwordState = mutableStateOf("")
    val passwordErrorState = mutableStateOf<String?>(null)
    val auth = Firebase.auth
    val isLoading = mutableStateOf(false)
    val events = mutableStateOf<RegisterEvent>(RegisterEvent.Idle)
    fun register() {
        if (validateFields()) {
            // Register
            isLoading.value = true
            auth.createUserWithEmailAndPassword(emailState.value, passwordState.value)
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        isLoading.value = false
                        Log.e("TAG", "register: ${task.exception?.message}")
                        return@addOnCompleteListener
                    }
                    val uid = task.result.user?.uid
                    // Add user to cloud Fire store
                    addUserToFirestore(uid)
                }
        }
    }

    private fun addUserToFirestore(uid: String?) {

        val user = AppUser(uid, firstNameState.value, emailState.value)
        FirebaseUtils.addUser(user, onSuccessListener = {
            isLoading.value = false
            events.value = RegisterEvent.NavigateToHome(user)
        }, onFailureListener = {
            isLoading.value = false
            Log.e("Tag", "addUserToFirestore: ${it.message}")
        })
    }

    fun validateFields(): Boolean {
        if (firstNameState.value.isEmpty() && firstNameState.value.isBlank()) {
            firstNameErrorState.value = "Required"
            return false
        } else {
            firstNameErrorState.value = null
        }
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
}
