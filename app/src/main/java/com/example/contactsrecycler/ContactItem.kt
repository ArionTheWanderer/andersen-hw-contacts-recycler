package com.example.contactsrecycler


data class ContactItem(
    val id: Int,
    val name: String,
    val surname: String,
    val phoneNumber: String,
    val imageUri: String = "https://picsum.photos/150"
)
