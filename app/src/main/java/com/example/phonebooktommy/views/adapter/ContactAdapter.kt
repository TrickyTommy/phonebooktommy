package com.example.phonebooktommy.views.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phonebooktommy.databinding.ItemListBinding
import com.example.phonebooktommy.repository.responses.ContactResponse

class ContactAdapter(private val context: Context, private val listener: contacListener):
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    inner class ViewHolder(
        private val binding: ItemListBinding,
        private val listener: contacListener
    ) : RecyclerView.ViewHolder(binding.root){
        fun bindData(contactModel:ContactResponse) {
            binding.run {

            }
        }

    }

    interface contacListener {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}