package org.multimes.backend.core.web.repository.interfaces

import org.multimes.backend.core.web.model.entities.Message

interface IMessageRepository {
    fun add(message: Message)
    fun getAllByInterId(id: Int): List<Message>
}
