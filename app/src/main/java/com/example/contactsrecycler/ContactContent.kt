package com.example.contactsrecycler

import android.view.View
import java.util.ArrayList


object ContactContent {

    private val ITEMS: MutableList<ContactItem> = ArrayList()
    val contacts: List<ContactItem>
        get() = ITEMS

    private const val COUNT = 101

    init {
        for (i in 1..COUNT) {
            addItem(createContactItem(i))
        }
    }

    private fun addItem(item: ContactItem) {
        ITEMS.add(item)
    }

    private fun createContactItem(position: Int): ContactItem {
        val phoneNumber = when {
            position < 10 -> "8800555353$position"
            position in 10..99 -> "880055535$position"
            position > 100 -> "88005553$position"
            else -> "112"
        }
        return ContactItem(View.generateViewId(), "John $position", "Doe $position", phoneNumber)
    }
}
