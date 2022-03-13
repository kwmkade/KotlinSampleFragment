package com.kwmkade.kotlinsamplefragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kwmkade.kotlinsamplefragment.databinding.FragmentItemBinding

class ItemRecyclerViewAdapter : RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder>() {

    private val _itemList = mutableListOf<ItemViewModel.Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentItemBinding.inflate(
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

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}