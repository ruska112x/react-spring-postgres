package org.multimes.backend.core.tg.handler;

import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;

import org.multimes.backend.core.web.model.entities.Dialog;
import org.multimes.backend.core.web.model.entities.Message;
import org.multimes.backend.core.web.repository.interfaces.IDialogRepository;
import org.multimes.backend.core.web.repository.interfaces.IMessageRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class TgHandler {
    private final TelegramBot bot;

    private final IMessageRepository messageRepository;
    private final IDialogRepository dialogRepository;

    public TgHandler(TelegramBot bot, IMessageRepository messageRepository, IDialogRepository dialogRepository) {
        this.bot = bot;
        this.messageRepository = messageRepository;
        this.dialogRepository = dialogRepository;
    }

    private int oldMesId = -1;
    private int offset = 0;

    private String getFullName(Chat chat) {
        String firstName = chat.firstName();
        String lastName = chat.lastName();
        StringBuffer usernameBuffer = new StringBuffer();
        if (firstName != null) {
            usernameBuffer.append(firstName);
        }
        if (lastName != null) {
            usernameBuffer.append(" ");
            usernameBuffer.append(lastName);
        }
        return usernameBuffer.toString();
    }

    private String getCurrentTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString();
    }

    @Scheduled(fixedRate = 1000)
    public void newGetUpdates() {
        GetUpdates getUpdates = new GetUpdates().offset(offset);
        bot.execute(getUpdates, new Callback<GetUpdates, GetUpdatesResponse>() {
            @Override
            public void onResponse(GetUpdates request, GetUpdatesResponse response) {
                List<Update> updates = response.updates();
                if (updates != null) {
                    for (int i = 0; i < updates.size(); ++i) {
                        Update update = updates.get(i);
                        int mesId = update.message().messageId();
                        Chat chat = update.message().chat();
                        long chatId = chat.id();
                        String username = getFullName(chat);
                        int interId = dialogRepository.checkExistsWithIdInMessenger(chatId);
                        if (interId == -1) {
                            Dialog newDialog = new Dialog(-1, chatId, username, "telegram");
                            interId = dialogRepository.add(newDialog);
                        }
                        if (mesId != oldMesId) {
                            String text = update.message().text();
                            if (text == null || text.isEmpty()) {
                                text = "[UNSUPPORTED_FORMAT]";
                            }
                            String time = getCurrentTime();
                            messageRepository.add(new Message(-1, text, time, true, interId));
                            oldMesId = mesId;
                        }
                        if (i == updates.size() - 1) {
                            offset = update.updateId() + 1;
                        }
                    }
                }
            }

            @Override
            public void onFailure(GetUpdates request, IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    public void sendMessage(long chatId, String message) {
        bot.execute(new SendMessage(chatId, message));
    }
}
