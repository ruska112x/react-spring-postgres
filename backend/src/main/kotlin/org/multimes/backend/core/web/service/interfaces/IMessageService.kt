package org.multimes.backend.core.web.service.interfaces

import org.multimes.backend.core.web.model.dto.requests.SendMessageRequest
import org.multimes.backend.core.web.model.dto.responses.AllMessagesByDialogIdResponse

interface IMessageService {
    fun add(message: SendMessageRequest)
    fun getAllByInterId(id: Int): List<AllMessagesByDialogIdResponse>
}
