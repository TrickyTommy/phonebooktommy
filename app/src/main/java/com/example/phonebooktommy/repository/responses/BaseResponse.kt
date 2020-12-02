package com.example.phonebooktommy.repository.responses

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
	@SerializedName("data")
	val data: T,
	@SerializedName("status")
	val status: Boolean,
	@SerializedName("message")
	val message: String,
)