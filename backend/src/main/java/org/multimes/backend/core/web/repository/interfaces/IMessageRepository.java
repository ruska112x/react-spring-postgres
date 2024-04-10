package org.multimes.backend.core.web.repository.interfaces;

import org.multimes.backend.core.web.model.entities.Message;

import java.util.List;

public interface IMessageRepository {
    public void add(Message message);

    public List<Message> getAllByInterId(int id);
}
