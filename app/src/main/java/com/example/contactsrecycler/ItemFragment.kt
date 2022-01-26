package com.example.contactsrecycler

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import com.example.contactsrecycler.databinding.FragmentItemListBinding


class ItemFragment : Fragment(), MyItemRecyclerViewAdapter.OnListFragmentInteractionListener {

    private lateinit var _binding: FragmentItemListBinding
    private val binding get() = _binding
    private val viewModel: ContactsViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.contacts.observe(viewLifecycleOwner) { contacts ->
            binding.root.adapter = MyItemRecyclerViewAdapter(contacts, this, requireContext())
        }
    }

    override fun onListFragmentInteraction(itemId: Int?) {
        Log.e("ItemFragment", "Contact id to bundle: $itemId")
        setFragmentResult(SHOW_DETAILS_REQUEST_KEY, bundleOf(BUNDLE_KEY to itemId))
    }

    companion object {
        const val SHOW_DETAILS_REQUEST_KEY = "SHOW_DETAILS_REQUEST_KEY"
        const val BUNDLE_KEY = "BUNDLE_KEY"
    }
}
