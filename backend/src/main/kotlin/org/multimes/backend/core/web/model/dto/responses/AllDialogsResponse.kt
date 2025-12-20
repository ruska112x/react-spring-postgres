package org.multimes.backend.core.web.model.dto.responses

data class AllDialogsResponse(
    val dialogId: Int = -1,
    val fullName: String? = null,
    val messengerType: String? = null
)
