package org.multimes.backend.core.web.service;

import org.multimes.backend.core.web.model.dto.responses.AllDialogsResponse;
import org.multimes.backend.core.web.model.entities.Dialog;
import org.multimes.backend.core.web.repository.interfaces.IDialogRepository;
import org.multimes.backend.core.web.service.interfaces.IDialogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DialogService implements IDialogService {
    private final IDialogRepository interRepository;

    public DialogService(IDialogRepository interRepository) {
        this.interRepository = interRepository;
    }

    @Override
    public List<AllDialogsResponse> getAll() {
        List<Dialog> dialogs = interRepository.getAll();
        List<AllDialogsResponse> result = new ArrayList<>();
        for (Dialog d : dialogs) {
            AllDialogsResponse response = new AllDialogsResponse(d.getInterId(), d.getFullName(), d.getMessengerType());
            result.add(response);
        }
        return result;
    }
}
