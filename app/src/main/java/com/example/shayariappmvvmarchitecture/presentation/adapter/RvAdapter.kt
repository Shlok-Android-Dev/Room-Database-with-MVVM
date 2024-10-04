package com.example.shayariappmvvmarchitecture.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shayariappmvvmarchitecture.data.DataEntity
import com.example.shayariappmvvmarchitecture.databinding.ActivityAddEditBinding.inflate
import com.example.shayariappmvvmarchitecture.databinding.RvItemBinding

class ShayariAdapter(private val onItemClicked: (DataEntity) -> Unit) :
    ListAdapter<DataEntity, ShayariAdapter.ShayariViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShayariViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShayariViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShayariViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class ShayariViewHolder(private val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dataEntity: DataEntity) {
            binding.titleTextView.text = dataEntity.title

            binding.root.setOnClickListener {
                onItemClicked(dataEntity)
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<DataEntity>() {
            override fun areItemsTheSame(oldItem: DataEntity, newItem: DataEntity) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: DataEntity, newItem: DataEntity) =
                oldItem == newItem
        }
    }
}