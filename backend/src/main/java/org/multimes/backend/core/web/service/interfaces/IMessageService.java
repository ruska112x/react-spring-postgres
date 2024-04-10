package org.multimes.backend.core.web.service.interfaces;

import org.multimes.backend.core.web.model.dto.requests.SendMessageRequest;
import org.multimes.backend.core.web.model.dto.responses.AllMessagesByDialogIdResponse;

import java.util.List;

public interface IMessageService {
    public void add(SendMessageRequest message);

    List<AllMessagesByDialogIdResponse> getAllByInterId(int id);
}
