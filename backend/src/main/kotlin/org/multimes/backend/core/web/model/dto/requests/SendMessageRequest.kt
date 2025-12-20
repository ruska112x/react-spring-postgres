package org.multimes.backend.core.web.model.dto.requests

data class SendMessageRequest(
    val text: String? = null,
    val dialogId: Int = -1
)
