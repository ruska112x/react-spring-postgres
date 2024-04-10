package org.multimes.backend.core.web.controller;

import org.multimes.backend.core.web.model.dto.requests.SendMessageRequest;
import org.multimes.backend.core.web.model.dto.responses.AllMessagesByDialogIdResponse;
import org.multimes.backend.core.web.service.interfaces.IMessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {
    private final IMessageService messageService;

    public MessagesController(IMessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<AllMessagesByDialogIdResponse> getAllMessages(@RequestParam int id) {
        return messageService.getAllByInterId(id);
    }

    @PostMapping
    public void sendMessage(@RequestBody SendMessageRequest message) {
        messageService.add(message);
    }

}
