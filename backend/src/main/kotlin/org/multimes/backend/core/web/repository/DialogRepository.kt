package org.multimes.backend.core.web.repository

import org.multimes.backend.core.web.model.entities.Dialog
import org.multimes.backend.core.web.repository.interfaces.IDialogRepository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository

@Repository
class DialogRepository(private val jdbcTemplate: JdbcTemplate) : IDialogRepository {

    override fun add(dialog: Dialog): Int {
        val sql = "insert into inters (id_in_messenger, full_name, messenger_type) values (?, ?, ?)"
        val generatedKeyHolder = GeneratedKeyHolder()
        jdbcTemplate.update({ conn ->
            val preparedStatement = conn.prepareStatement(sql, arrayOf("inter_id"))
            preparedStatement.setLong(1, dialog.idInMessenger)
            preparedStatement.setString(2, dialog.fullName)
            preparedStatement.setString(3, dialog.messengerType)
            preparedStatement
        }, generatedKeyHolder)
        return generatedKeyHolder.key as Int
    }

    override fun getById(id: Int): Dialog {
        val sql = "select * from inters where inter_id = ?"
        return jdbcTemplate.queryForObject(sql, { rs, _ ->
            Dialog(
                interId = rs.getInt("inter_id"),
                idInMessenger = rs.getLong("id_in_messenger"),
                fullName = rs.getString("full_name"),
                messengerType = rs.getString("messenger_type")
            )
        }, id)!!
    }

    override fun checkExistsWithIdInMessenger(id: Long): Int {
        val sql = "select * from inters where id_in_messenger = ?"
        val rows = jdbcTemplate.queryForList(sql, id)
        val result = rows.map { row ->
            Dialog(
                interId = row["inter_id"] as Int,
                idInMessenger = row["id_in_messenger"] as Long,
                fullName = row["full_name"] as String?,
                messengerType = row["messenger_type"] as String?
            )
        }
        return result.firstOrNull()?.interId ?: -1
    }

    override fun getAll(): List<Dialog> {
        val sql = "select * from inters"
        val rows = jdbcTemplate.queryForList(sql)
        return rows.map { row ->
            Dialog(
                interId = row["inter_id"] as Int,
                idInMessenger = row["id_in_messenger"] as Long,
                fullName = row["full_name"] as String?,
                messengerType = row["messenger_type"] as String?
            )
        }
    }
}
