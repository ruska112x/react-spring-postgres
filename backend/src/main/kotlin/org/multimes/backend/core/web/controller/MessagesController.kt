package org.multimes.backend.core.web.controller

import org.multimes.backend.core.web.model.dto.requests.SendMessageRequest
import org.multimes.backend.core.web.model.dto.responses.AllMessagesByDialogIdResponse
import org.multimes.backend.core.web.service.interfaces.IMessageService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messages")
class MessagesController(private val messageService: IMessageService) {

    @GetMapping
    fun getAllMessages(@RequestParam id: Int): List<AllMessagesByDialogIdResponse> {
        return messageService.getAllByInterId(id)
    }

    @PostMapping
    fun sendMessage(@RequestBody message: SendMessageRequest) {
        messageService.add(message)
    }
}
