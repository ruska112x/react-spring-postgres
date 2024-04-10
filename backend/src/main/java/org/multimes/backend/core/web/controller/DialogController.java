package org.multimes.backend.core.web.controller;

import org.multimes.backend.core.web.model.dto.responses.AllDialogsResponse;
import org.multimes.backend.core.web.service.interfaces.IDialogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dialogs")
public class DialogController {
    private final IDialogService dialogService;

    public DialogController(IDialogService dialogService) {
        this.dialogService = dialogService;
    }

    @GetMapping
    public List<AllDialogsResponse> getAllDialogs() {
        return dialogService.getAll();
    }
}
