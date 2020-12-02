package com.example.phonebooktommy.views.states

import com.example.phonebooktommy.repository.responses.ContactResponse

sealed class ContactState {
    data class Loading(val message: String = "Loading...") : ContactState()
    data class Error(val exception: Exception) : ContactState()
    data class SuccessGetAllContact(val list: List<ContactResponse>) : ContactState()
    data class SuccessInsertContact(val Contact: ContactResponse) : ContactState()
    data class SuccessUpdateContact(val Contact: ContactResponse) : ContactState()
    data class SuccessDeleteContact(val Contact: ContactResponse) : ContactState()
    data class SuccessGetAllFavorite(val list: List<ContactResponse>) : ContactState()
    data class SuccessInsertFavorite(val Contact: ContactResponse) : ContactState()
    data class SuccessDeleteFavorite(val Contact: ContactResponse) : ContactState()
}