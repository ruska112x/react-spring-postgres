package org.multimes.backend.core.web.service

import org.multimes.backend.core.web.model.dto.responses.AllDialogsResponse
import org.multimes.backend.core.web.repository.interfaces.IDialogRepository
import org.multimes.backend.core.web.service.interfaces.IDialogService
import org.springframework.stereotype.Service

@Service
class DialogService(private val interRepository: IDialogRepository) : IDialogService {

    override fun getAll(): List<AllDialogsResponse> {
        val dialogs = interRepository.getAll()
        return dialogs.map { d ->
            AllDialogsResponse(d.interId, d.fullName, d.messengerType)
        }
    }
}
