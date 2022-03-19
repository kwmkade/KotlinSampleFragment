package com.kwmkade.kotlinsamplefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CardFragment : Fragment() {

    private val _viewModel: ItemViewModel by activityViewModels()

    private lateinit var _adapter: CardRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_card_list, container, false)

        _adapter = CardRecyclerViewAdapter()

        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = _adapter
                setHasFixedSize(true)
            }
        }

        _viewModel.ITEMS.observe(viewLifecycleOwner) {
            _adapter.setItem(it)
        }

        return view
    }
}