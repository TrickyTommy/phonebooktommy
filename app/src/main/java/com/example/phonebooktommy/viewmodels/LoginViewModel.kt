package com.example.phonebooktommy.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phonebooktommy.repository.clients.LoginClient
import com.example.phonebooktommy.repository.responses.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

sealed class LoginState {
    data class Loading(val message: String = "Loading...") : LoginState()
    data class Error(val exception: Exception) : LoginState()
    data class Login(val data: LoginResponse) : LoginState()
}

class LoginViewModel : ViewModel() {
    private val loginService by lazy { LoginClient.service }
    private val mutablestate by lazy { MutableLiveData<LoginState>() }
    val state: LiveData<LoginState> get() = mutablestate

    fun login(email: String, password: String) {
        val body = hashMapOf<String, Any>("email" to email,"password" to password)

        mutablestate.value = LoginState.Loading()

        viewModelScope.launch ( Dispatchers.IO){
            try {
                val loginModel = loginService.getLogin(body).data
                mutablestate.postValue(LoginState.Login(loginModel))
            }catch (exc: Exception){
                exc.printStackTrace()
                mutablestate.postValue(LoginState.Error(exc))
        }
        }
    }
}
