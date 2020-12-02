package com.example.phonebooktommy.repository.services

import com.example.phonebooktommy.repository.request.LoginRequest
import com.example.phonebooktommy.repository.responses.BaseResponse
import com.example.phonebooktommy.repository.responses.LoginResponse

import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("v1/signin")
    suspend fun getLogin(@Body loginRequest: HashMap<String,Any>) : BaseResponse<LoginResponse>
}