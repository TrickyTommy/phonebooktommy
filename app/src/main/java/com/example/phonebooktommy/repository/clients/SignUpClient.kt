package com.example.phonebooktommy.repository.clients

import com.example.phonebooktommy.repository.services.SignUpService
import com.example.phonebooktommy.repository.utils.ConstantUtil
import com.google.gson.GsonBuilder

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SignUpClient {
    private val interceptor by lazy { HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)}

    private val client by lazy { OkHttpClient.Builder().addInterceptor(interceptor).build()}

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(ConstantUtil.BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .client(client)
            .build()
    }
    val signupService by lazy {
        retrofit.create(SignUpService::class.java)
    }
}