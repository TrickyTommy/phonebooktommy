package com.example.phonebooktommy.repository.responses

import com.google.gson.annotations.SerializedName

data class addContactResponse(

	val image: Any,
	val phone: String,
	val name: String,
	val company: Any,
	val id: Long,
	val job: String,
	val userId: Long,
	val email: String
)