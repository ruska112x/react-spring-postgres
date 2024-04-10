package org.multimes.backend.core.web.repository.interfaces;

import org.multimes.backend.core.web.model.entities.Dialog;

import java.util.List;

public interface IDialogRepository {
    public int add(Dialog dialog);

    public Dialog getById(int id);

    public int checkExistsWithIdInMessenger(long id);

    public List<Dialog> getAll();
}
