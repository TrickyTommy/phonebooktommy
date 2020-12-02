package com.example.phonebooktommy.views.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.phonebooktommy.databinding.FragmentAddContactBinding
import com.example.phonebooktommy.repository.ContactLocalRepository
import com.example.phonebooktommy.repository.ContactRemoteRepository
import com.example.phonebooktommy.repository.ContactRemoteRepositoryImpl
import com.example.phonebooktommy.viewmodels.AddContactViewModel
import com.example.phonebooktommy.viewmodels.AddContactViewModelFactory
import com.example.phonebooktommy.views.states.ContactState

import java.io.*
import java.text.SimpleDateFormat
import java.util.*

class AddFragment : Fragment() {

    lateinit var binding: FragmentAddContactBinding
    private val service: ContactService by lazy { Api.contactService }
    private val dao: ContactDao by lazy { LocalDB.getDB(requireContext()).dao() }
    private val remoteRepository: ContactRemoteRepository by lazy { ContactRemoteRepositoryImpl(service) }
    private val localRepository: ContactLocalRepository by lazy { ContactLocalRepositoryImpl(dao) }
    private val viewModelFactory by lazy { AddContactViewModelFactory(remoteRepository, localRepository) }
    private val viewModel by viewModels<AddContactViewModel> { viewModelFactory }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)

        setView()
        setObserver()
        return binding.root
    }

    private fun setView(){
        binding.run {
            btAddContact.setOnClickListener {
                viewModel.insertContact(
                    BodyAddContact(
                        etAddContactName.text.toString(),
                        etAddContactPhone.text.toString(),
                        etAddContactJob.text.toString(),
                        etAddContactCompany.text.toString(),
                        etAddContactEmail.text.toString()
                    )
                )
            }
        }
    }
    private fun setObserver(){
        viewModel.state.observe(viewLifecycleOwner){
            when(it){
                is ContactAddState.Loading -> showLoading(true)
                is ContactAddState.Error -> {
                    showLoading(false)
                    showMessage(it.exception.message ?: "Oops something went wrong")
                }
                is ContactAddState.SuccessInsertContact -> {
                    showLoading(false)
                    requireActivity().onBackPressed()
                }
                else -> throw Exception("Unsupported state type")

            }
        }
    }

    private fun showLoading(state: Boolean){
        binding.apply {
            btAddContact.text = if (state) "" else "add"
            pbAdd.visibility = if (state) View.VISIBLE else View.GONE
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }



}