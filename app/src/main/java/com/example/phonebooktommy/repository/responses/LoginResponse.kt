package com.example.phonebooktommy.repository.responses

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	val password: String,
	val name: String,
	val id: Long,
	val email: String,
	val token: String
)