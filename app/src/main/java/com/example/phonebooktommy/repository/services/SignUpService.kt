package com.example.phonebooktommy.repository.services


import com.example.phonebooktommy.repository.request.SignUpRequest
import com.example.phonebooktommy.repository.responses.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {

    @POST("v1/signup")
    suspend fun getSignUp(@Body signUpRequest: SignUpRequest) : BaseResponse<String>
}