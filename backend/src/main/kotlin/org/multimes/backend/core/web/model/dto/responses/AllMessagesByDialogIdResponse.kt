package org.multimes.backend.core.web.model.dto.responses

data class AllMessagesByDialogIdResponse(
    val text: String? = null,
    val time: String? = null,
    val isInter: Boolean = false
)
