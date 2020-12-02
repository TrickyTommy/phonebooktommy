package com.example.phonebooktommy.repository.responses

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
	val data: T,
	val message: String,
	val status: Boolean
)