package org.multimes.backend.core.web.controller

import org.multimes.backend.core.web.model.dto.responses.AllDialogsResponse
import org.multimes.backend.core.web.service.interfaces.IDialogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dialogs")
class DialogController(private val dialogService: IDialogService) {

    @GetMapping
    fun getAllDialogs(): List<AllDialogsResponse> {
        return dialogService.getAll()
    }
}
