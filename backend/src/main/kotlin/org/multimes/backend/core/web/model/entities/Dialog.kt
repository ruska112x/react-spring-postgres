package org.multimes.backend.core.web.model.entities

data class Dialog(
    val interId: Int = -1,
    val idInMessenger: Long = -1,
    val fullName: String? = null,
    val messengerType: String? = null
)
