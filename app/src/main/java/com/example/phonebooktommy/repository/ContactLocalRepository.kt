package com.example.phonebooktommy.repository

import com.example.phonebooktommy.repository.local.entity.ContactEntity

interface ContactLocalRepository {
    suspend fun getAllContact(): List<ContactEntity>
    suspend fun insertContact(contactEntity: ContactEntity)
    suspend fun deleteContact(contactEntity: ContactEntity)
    suspend fun isFavorite(id: Long): Boolean

}
