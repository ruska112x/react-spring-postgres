package org.multimes.backend.core.web.repository;

import org.multimes.backend.core.web.model.entities.Message;
import org.multimes.backend.core.web.repository.interfaces.IMessageRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MessageRepository implements IMessageRepository {
    private final JdbcTemplate jdbcTemplate;

    public MessageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Message message) {
        String sql = "insert into messages (mes_text, mes_time, is_inter, inter_id) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                message.getMesText(), message.getMesTime(), message.getIsInter(), message.getInterId());
    }

    @Override
    public List<Message> getAllByInterId(int id) {
        String sql = "select * from messages where inter_id = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id);
        List<Message> result = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            Message message = new Message(
                    (Integer) row.get("mes_id"),
                    (String) row.get("mes_text"),
                    (String) row.get("mes_time"),
                    (Boolean) row.get("is_inter"),
                    (Integer) row.get("inter_id"));
            result.add(message);
        }
        return result;
    }
}
