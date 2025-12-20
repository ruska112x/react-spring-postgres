package org.multimes.backend.core.web.model.entities

data class Message(
    val mesId: Int = -1,
    val mesText: String? = null,
    val mesTime: String? = null,
    val isInter: Boolean = false,
    val interId: Int = -1
)
