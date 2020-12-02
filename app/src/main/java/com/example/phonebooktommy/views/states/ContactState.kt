package com.example.phonebooktommy.views.states

sealed class ContactState {
    data class Loading(val message: String = "Loading...") : ContactState()
    data class Error(val exception: Exception) : ContactState()
    data class SuccessGetAllContact(val list: List<TodoModel>) : ContactState()
    data class SuccessInsertContact(val Contact: TodoModel) : ContactState()
    data class SuccessUpdateContact(val Contact: TodoModel) : ContactState()
    data class SuccessDeleteContact(val Contact: TodoModel) : ContactState()
    data class SuccessGetAllFavorite(val list: List<TodoModel>) : ContactState()
    data class SuccessInsertFavorite(val Contact: TodoModel) : ContactState()
    data class SuccessDeleteFavorite(val Contact: TodoModel) : ContactState()
}