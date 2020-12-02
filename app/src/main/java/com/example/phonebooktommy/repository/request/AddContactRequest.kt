package com.example.phonebooktommy.repository.request

data class AddContactRequest (
    var name: String,
    var phone: String,
    var job: String,
    var company: String,
    var email : String,
    var image: String? = null

)
