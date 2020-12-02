package com.example.phonebooktommy.repository.responses

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
	val data: String,
	val message: String,
	val status: Boolean
)