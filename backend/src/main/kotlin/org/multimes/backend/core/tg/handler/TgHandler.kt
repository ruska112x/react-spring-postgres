package org.multimes.backend.core.tg.handler

import com.pengrad.telegrambot.Callback
import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.model.Chat
import com.pengrad.telegrambot.model.Update
import com.pengrad.telegrambot.request.GetUpdates
import com.pengrad.telegrambot.request.SendMessage
import com.pengrad.telegrambot.response.GetUpdatesResponse
import org.multimes.backend.core.web.model.entities.Dialog
import org.multimes.backend.core.web.model.entities.Message
import org.multimes.backend.core.web.repository.interfaces.IDialogRepository
import org.multimes.backend.core.web.repository.interfaces.IMessageRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.io.IOException
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Component
class TgHandler(
    private val bot: TelegramBot,
    private val messageRepository: IMessageRepository,
    private val dialogRepository: IDialogRepository
) {

    private var oldMesId = -1
    private var offset = 0

    private fun getFullName(chat: Chat): String {
        val firstName = chat.firstName()
        val lastName = chat.lastName()
        return buildString {
            if (firstName != null) {
                append(firstName)
            }
            if (lastName != null) {
                append(" ")
                append(lastName)
            }
        }
    }

    private fun getCurrentTime(): String {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
    }

    @Scheduled(fixedRate = 1000)
    fun newGetUpdates() {
        val getUpdates = GetUpdates().offset(offset)
        bot.execute(getUpdates, object : Callback<GetUpdates, GetUpdatesResponse> {
            override fun onResponse(request: GetUpdates, response: GetUpdatesResponse) {
                val updates = response.updates()
                if (updates != null) {
                    for (i in updates.indices) {
                        val update = updates[i]
                        val mesId = update.message().messageId()
                        val chat = update.message().chat()
                        val chatId = chat.id()
                        val username = getFullName(chat)
                        var interId = dialogRepository.checkExistsWithIdInMessenger(chatId)
                        if (interId == -1) {
                            val newDialog = Dialog(-1, chatId, username, "telegram")
                            interId = dialogRepository.add(newDialog)
                        }
                        if (mesId != oldMesId) {
                            val text = update.message().text()?.takeIf { it.isNotEmpty() } ?: "[UNSUPPORTED_FORMAT]"
                            val time = getCurrentTime()
                            messageRepository.add(Message(-1, text, time, true, interId))
                            oldMesId = mesId
                        }
                        if (i == updates.size - 1) {
                            offset = update.updateId() + 1
                        }
                    }
                }
            }

            override fun onFailure(request: GetUpdates, e: IOException) {
                println(e.message)
            }
        })
    }

    fun sendMessage(chatId: Long, message: String) {
        bot.execute(SendMessage(chatId, message))
    }
}
