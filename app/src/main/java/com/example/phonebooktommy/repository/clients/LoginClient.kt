package com.example.phonebooktommy.repository.clients

import android.util.Log
import com.example.phonebooktommy.BuildConfig
import com.example.phonebooktommy.repository.services.LoginService
import com.example.phonebooktommy.repository.utils.ConstantUtil
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginClient {
    companion object {
        val service: LoginService by lazy {
            val httpLoggingInterceptor = HttpLoggingInterceptor { message ->
                if (BuildConfig.DEBUG) Log.e("LOG_API", message)
            }
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient = OkHttpClient()
                .newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

            val retrofit = Retrofit
                .Builder()
                .baseUrl(ConstantUtil.BASE_URL_API)
                .client(okHttpClient)
                .addConverterFactory(
                    GsonConverterFactory.create(GsonBuilder().setLenient().create())
                )
                .build()
            retrofit.create(LoginService::class.java)
        }
    }
}