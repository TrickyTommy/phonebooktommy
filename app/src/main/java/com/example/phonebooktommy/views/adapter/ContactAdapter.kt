package com.example.phonebooktommy.views.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
                tvName.text=contactModel.name
                tvPhone.text=contactModel.phone

                Glide.with(binding.root).load(contactModel.image).into(ivAvatar)

                root.setOnClickListener { listener.onClick(contactModel)}

            }
        }

    }

    interface contacListener {
        fun onClick(productModel: ContactResponse)
        fun onDelete(productModel: ContactResponse)
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