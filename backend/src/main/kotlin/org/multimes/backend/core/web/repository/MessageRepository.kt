package org.multimes.backend.core.web.repository

import org.multimes.backend.core.web.model.entities.Message
import org.multimes.backend.core.web.repository.interfaces.IMessageRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class MessageRepository(private val jdbcTemplate: JdbcTemplate) : IMessageRepository {

    override fun add(message: Message) {
        val sql = "insert into messages (mes_text, mes_time, is_inter, inter_id) values (?, ?, ?, ?)"
        jdbcTemplate.update(sql, message.mesText, message.mesTime, message.isInter, message.interId)
    }

    override fun getAllByInterId(id: Int): List<Message> {
        val sql = "select * from messages where inter_id = ?"
        val rows = jdbcTemplate.queryForList(sql, id)
        return rows.map { row ->
            Message(
                mesId = row["mes_id"] as Int,
                mesText = row["mes_text"] as String?,
                mesTime = row["mes_time"] as String?,
                isInter = row["is_inter"] as Boolean,
                interId = row["inter_id"] as Int
            )
        }
    }
}
