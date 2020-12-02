package com.example.phonebooktommy.repository.services


import com.example.phonebooktommy.repository.responses.BaseResponse
import com.example.phonebooktommy.repository.responses.ContactResponse
import okhttp3.RequestBody
import retrofit2.http.*

interface ContactService {

    @GET("api/v1/contacts")
    suspend fun getAllContact(
        @Header("Authorization")
        token: String
    ): BaseResponse<List<ContactResponse>>

    @DELETE("api/v1/contacts/{id}")
    suspend fun deleteContact(
        @Header("Authorization")
        token: String,
        @Path("id")
        id: Int
    ): BaseResponse<String>

    @Multipart
    @POST("api/v1/contacts")
    suspend fun addContact(
        @Header("Authorization")
        token: String,
        @Part("name")
        name: RequestBody,
        @Part("phone")
        phone: RequestBody,
        @Part("email")
        email: RequestBody,
        @Part("job")
        job: RequestBody,
        @Part("company")
        company: RequestBody,
        @Part("image")
        image: RequestBody? = null,
    ): BaseResponse<ContactResponse>

    @Multipart
    @PUT("api/v1/contacts/{id}")
    suspend fun updateContact(
        @Header("Authorization")
        token: String,
        @Path("id")
        id: Int,
        @Part("name")
        name: RequestBody,
        @Part("phone")
        phone: RequestBody,
        @Part("email")
        email: RequestBody,
        @Part("job")
        job: RequestBody,
        @Part("company")
        company: RequestBody,
        @Part("image")
        image: RequestBody? = null,
    ): BaseResponse<ContactResponse>
}