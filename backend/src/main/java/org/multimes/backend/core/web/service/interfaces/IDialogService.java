package org.multimes.backend.core.web.service.interfaces;

import org.multimes.backend.core.web.model.dto.responses.AllDialogsResponse;

import java.util.List;

public interface IDialogService {
    public List<AllDialogsResponse> getAll();
}
