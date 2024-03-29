package com.route.chatappc39gsat.model

data class Room(
    val name: String? = null,
    val description: String? = null,
    val categoryId: String? = null,

    ) {
    companion object {
        val COLLECTION_NAME = "Rooms"
    }

}
