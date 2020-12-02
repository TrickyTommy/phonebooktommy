package com.example.phonebooktommy.repository

import com.example.phonebooktommy.repository.request.AddContactRequest
import com.example.phonebooktommy.repository.responses.BaseResponse
import com.example.phonebooktommy.repository.responses.ContactResponse
import com.example.phonebooktommy.repository.services.ContactService
import okhttp3.MediaType
import okhttp3.RequestBody

class ContactRemoteRepositoryImpl(private val service: ContactService) : ContactRemoteRepository {


    override suspend fun getAllContact(token: String): BaseResponse<List<ContactResponse>> {
        return service.getAllContact(token)
    }

    override suspend fun deleteContact(token: String, id: Int): BaseResponse<String> {
        return service.deleteContact(token, id)
    }

    override suspend fun addContact(
        token: String,
        addContactRequest: AddContactRequest
    ): BaseResponse<ContactResponse> {
        return service.addContact(
            token,
            RequestBody.create(MediaType.parse("text/plain"), addContactRequest.name),
            RequestBody.create(MediaType.parse("text/plain"), addContactRequest.phone),
            RequestBody.create(MediaType.parse("text/plain"), addContactRequest.email),
            RequestBody.create(MediaType.parse("text/plain"), addContactRequest.job),
            RequestBody.create(MediaType.parse("text/plain"), addContactRequest.company)
        )
    }


    override suspend fun updateContact(
        token: String,
        id: Int,
        addContactRequest: AddContactRequest
    ): BaseResponse<ContactResponse> {
        return service.updateContact(
            token,
            id,
            RequestBody.create(MediaType.parse("text/plain"), addContactRequest.name),
            RequestBody.create(MediaType.parse("text/plain"), addContactRequest.phone),
            RequestBody.create(MediaType.parse("text/plain"), addContactRequest.email),
            RequestBody.create(MediaType.parse("text/plain"), addContactRequest.job),
            RequestBody.create(MediaType.parse("text/plain"), addContactRequest.company)
        )
    }


}