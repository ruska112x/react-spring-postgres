package org.multimes.backend.core.web.service;

import org.multimes.backend.core.tg.handler.TgHandler;
import org.multimes.backend.core.web.model.dto.requests.SendMessageRequest;
import org.multimes.backend.core.web.model.dto.responses.AllMessagesByDialogIdResponse;
import org.multimes.backend.core.web.model.entities.Dialog;
import org.multimes.backend.core.web.model.entities.Message;
import org.multimes.backend.core.web.repository.interfaces.IDialogRepository;
import org.multimes.backend.core.web.repository.interfaces.IMessageRepository;
import org.multimes.backend.core.web.service.interfaces.IMessageService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService implements IMessageService {
    private final IMessageRepository messageRepository;

    private final IDialogRepository dialogRepository;

    private final TgHandler tgHandler;

    public MessageService(IMessageRepository messageRepository, IDialogRepository dialogRepository,
            TgHandler tgHandler) {
        this.messageRepository = messageRepository;
        this.dialogRepository = dialogRepository;
        this.tgHandler = tgHandler;
    }

    @Override
    public void add(SendMessageRequest message) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString();
        Message m = new Message(-1, message.getText(), time, false, message.getDialogId());
        messageRepository.add(m);
        Dialog dialog = dialogRepository.getById(message.getDialogId());
        long chatId = dialog.getIdInMessenger();
        tgHandler.sendMessage(chatId, message.getText());
    }

    @Override
    public List<AllMessagesByDialogIdResponse> getAllByInterId(int id) {
        List<Message> messages = messageRepository.getAllByInterId(id);
        List<AllMessagesByDialogIdResponse> result = new ArrayList<>();
        for (Message m : messages) {
            AllMessagesByDialogIdResponse response = new AllMessagesByDialogIdResponse(m.getMesText(), m.getMesTime(),
                    m.getIsInter());
            result.add(response);
        }
        return result;
    }
}
