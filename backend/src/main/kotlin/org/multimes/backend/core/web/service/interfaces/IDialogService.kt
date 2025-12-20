package org.multimes.backend.core.web.service.interfaces

import org.multimes.backend.core.web.model.dto.responses.AllDialogsResponse

interface IDialogService {
    fun getAll(): List<AllDialogsResponse>
}
