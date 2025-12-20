package org.multimes.backend.core.web.repository.interfaces

import org.multimes.backend.core.web.model.entities.Dialog

interface IDialogRepository {
    fun add(dialog: Dialog): Int
    fun getById(id: Int): Dialog
    fun checkExistsWithIdInMessenger(id: Long): Int
    fun getAll(): List<Dialog>
}
