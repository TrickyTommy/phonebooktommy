package com.example.phonebooktommy.views.states

sealed class ContactState {
    data class Loading(val message: String = "Loading...") : ContactState()
    data class Error(val exception: Exception) : ContactState()
    data class SuccessGetAllTodo(val list: List<TodoModel>) : ContactState()
    data class SuccessInsertTodo(val todo: TodoModel) : ContactState()
    data class SuccessUpdateTodo(val todo: TodoModel) : ContactState()
    data class SuccessDeleteTodo(val todo: TodoModel) : ContactState()
    data class SuccessGetAllFavorite(val list: List<TodoModel>) : ContactState()
    data class SuccessInsertFavorite(val todo: TodoModel) : ContactState()
    data class SuccessDeleteFavorite(val todo: TodoModel) : ContactState()
}