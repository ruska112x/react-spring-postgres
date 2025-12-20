package org.multimes.backend.core.web.service

import org.multimes.backend.core.tg.handler.TgHandler
import org.multimes.backend.core.web.model.dto.requests.SendMessageRequest
import org.multimes.backend.core.web.model.dto.responses.AllMessagesByDialogIdResponse
import org.multimes.backend.core.web.model.entities.Message
import org.multimes.backend.core.web.repository.interfaces.IDialogRepository
import org.multimes.backend.core.web.repository.interfaces.IMessageRepository
import org.multimes.backend.core.web.service.interfaces.IMessageService
import org.springframework.stereotype.Service
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Service
class MessageService(
    private val messageRepository: IMessageRepository,
    private val dialogRepository: IDialogRepository,
    private val tgHandler: TgHandler
) : IMessageService {

    override fun add(message: SendMessageRequest) {
        val time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
        val m = Message(-1, message.text, time, false, message.dialogId)
        messageRepository.add(m)
        val dialog = dialogRepository.getById(message.dialogId)
        val chatId = dialog.idInMessenger
        tgHandler.sendMessage(chatId, message.text!!)
    }

    override fun getAllByInterId(id: Int): List<AllMessagesByDialogIdResponse> {
        val messages = messageRepository.getAllByInterId(id)
        return messages.map { m ->
            AllMessagesByDialogIdResponse(m.mesText, m.mesTime, m.isInter)
        }
    }
}
