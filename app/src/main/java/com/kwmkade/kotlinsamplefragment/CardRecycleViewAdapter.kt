package com.kwmkade.kotlinsamplefragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kwmkade.kotlinsamplefragment.databinding.FragmentCardBinding

class CardRecyclerViewAdapter : RecyclerView.Adapter<CardRecyclerViewAdapter.ViewHolder>() {

    private val _itemList = mutableListOf<ItemViewModel.Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(item: ItemViewModel.Item) {
        _itemList.add(item)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = _itemList[position]
        holder.contentView.text = item.content
    }

    override fun getItemCount(): Int = _itemList.size

    inner class ViewHolder(binding: FragmentCardBinding) : RecyclerView.ViewHolder(binding.root) {
        val contentView: TextView = binding.cardContent

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}