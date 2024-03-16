package com.route.chatappc39gsat.model

data class AppUser(
    val uid: String? = null,
    val firstName: String? = null,
    val email: String? = null,

    ) {
    companion object {
        val COLLECTION_NAME = "users"
    }
}
