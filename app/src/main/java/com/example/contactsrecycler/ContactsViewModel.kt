package com.example.contactsrecycler

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactsViewModel : ViewModel() {
    private val _contacts = MutableLiveData(ContactContent.contacts)

    val contacts: LiveData<List<ContactItem>>
        get() = _contacts
}
