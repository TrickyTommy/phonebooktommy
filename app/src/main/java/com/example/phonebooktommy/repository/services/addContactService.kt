package com.example.phonebooktommy.repository.services


import com.example.phonebooktommy.repository.responses.BaseResponse
import com.example.phonebooktommy.repository.responses.ContactResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface addContactService {
    @Multipart
    @POST("v1/contacts")
    suspend fun insertContact(
        @Header("Authorization") token: String,
        @PartMap map: HashMap<String, RequestBody>,
        @Part image: MultipartBody.Part?
    ): BaseResponse<ContactResponse>

}