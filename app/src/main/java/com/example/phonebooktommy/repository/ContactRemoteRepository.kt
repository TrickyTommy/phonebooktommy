package com.example.phonebooktommy.repository

import com.example.phonebooktommy.repository.request.AddContactRequest
import com.example.phonebooktommy.repository.responses.BaseResponse
import com.example.phonebooktommy.repository.responses.ContactResponse

interface ContactRemoteRepository {

    suspend fun getAllContact(token: String ): BaseResponse<List<ContactResponse>>
    suspend fun deleteContact(token: String, id: Int): BaseResponse<String>
    suspend fun addContact(token: String, addContactRequest: AddContactRequest): BaseResponse<ContactResponse>
    suspend fun updateContact(token: String, id: Int, addContactRequest: AddContactRequest): BaseResponse<ContactResponse>

}