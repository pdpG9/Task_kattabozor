package com.example.task_kattabozor.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task_kattabozor.R
import com.example.task_kattabozor.data.network.models.Attribute
import com.example.task_kattabozor.databinding.ItemAttributeBinding

class AttributeAdapter : RecyclerView.Adapter<AttributeAdapter.AttributeVH>() {
    private var attributeList = emptyList<Attribute>()

    fun submitList(list: List<Attribute>) {
        attributeList = list
        notifyDataSetChanged()
    }

    inner class AttributeVH(binding: ItemAttributeBinding) : RecyclerView.ViewHolder(binding.root) {
        private val tvName = binding.tvTitle
        private val tvValue = binding.tvValue

        fun bind(position: Int) {
            tvName.text = "${attributeList[position].name}:"
            tvValue.text = attributeList[position].value
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributeVH =
        AttributeVH(
            ItemAttributeBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_attribute, parent, false)
            )
        )

    override fun getItemCount(): Int = attributeList.size

    override fun onBindViewHolder(holder: AttributeVH, position: Int) = holder.bind(position)
}