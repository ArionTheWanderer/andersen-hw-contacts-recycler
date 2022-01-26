package com.example.contactsrecycler

import android.content.Context
import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.ObjectKey
import com.example.contactsrecycler.databinding.FragmentItemBinding


class MyItemRecyclerViewAdapter(
    private val values: List<ContactItem>,
    private val mListener: OnListFragmentInteractionListener?,
    private val context: Context
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.nameView.text = item.name
        holder.surnameView.text = item.surname
        holder.phoneNumberView.text = item.phoneNumber
        Glide.with(context)
            .load(item.imageUri)
            .signature(ObjectKey(item.id))
            .error(R.drawable.ic_error)
            .override(150, 150)
            .into(holder.imageView)
        holder.root.setOnClickListener {
            mListener?.onListFragmentInteraction(item.id)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView = binding.itemImage
        val nameView: TextView = binding.itemName
        val surnameView: TextView = binding.itemSurname
        val phoneNumberView: TextView = binding.itemPhoneNumber
        val root = binding.root
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(itemId: Int?)
    }
}
