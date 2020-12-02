package com.example.phonebooktommy.viewmodels

import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.*
import com.example.phonebooktommy.repository.App
import com.example.phonebooktommy.repository.ContactLocalRepository
import com.example.phonebooktommy.repository.ContactRemoteRepository
import com.example.phonebooktommy.repository.UserSession
import com.example.phonebooktommy.repository.clients.ContactClient
import com.example.phonebooktommy.repository.request.AddContactRequest
import com.example.phonebooktommy.repository.responses.ContactResponse
import com.example.phonebooktommy.repository.utils.SessionUtil
import com.example.phonebooktommy.views.states.ContactState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

@Suppress("UNCHECKED_CAST")
class AddContactViewModelFactory(
    private val remoteRepository: ContactRemoteRepository,
    private val localRepository: ContactLocalRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddContactViewModel(remoteRepository, localRepository) as T
    }
}

class AddContactViewModel (
    private val remoteRepository: ContactRemoteRepository,
    private val localRepository: ContactLocalRepository,
) : ViewModel() {
    private val mutableState by lazy { MutableLiveData<ContactState>() }
    val state: LiveData<ContactState> get() = mutableState
    private val token by lazy {
        UserSession(App.instance).token
    }

    fun insertContact(bodyAddContact: AddContactRequest) {
        mutableState.value = ContactState.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val contact = remoteRepository.addContact(token!!, bodyAddContact)
                mutableState.postValue(ContactState.SuccessInsertContact(contact.data))
            } catch (exc: Exception) {

                exc.printStackTrace()
                mutableState.postValue(ContactState.Error(exc))
            }
        }
    }

}