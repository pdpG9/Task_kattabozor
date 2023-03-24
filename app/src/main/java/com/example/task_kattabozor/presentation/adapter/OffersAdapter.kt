package com.example.task_kattabozor.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task_kattabozor.R
import com.example.task_kattabozor.data.network.models.Offer
import com.example.task_kattabozor.databinding.ItemOfferBinding

class OffersAdapter : RecyclerView.Adapter<OffersAdapter.ViewHolder>() {
    private var offers = emptyList<Offer>()
    private var itemClickListener: ((Offer) -> Unit)? = null

    fun setClickListener(listener: (Offer) -> Unit) {
        itemClickListener = listener
    }

    fun submitList(list: List<Offer>) {
        offers = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(binding: ItemOfferBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener { itemClickListener?.invoke(offers[bindingAdapterPosition]) }
        }

        private val tvBrand = binding.tvBrand
        private val tvName = binding.tvName
        private val tvMerchant = binding.tvMerchant
        private val ivOffer = binding.ivOffer
        fun onBind(position: Int) {
            tvBrand.text = offers[position].brand
            tvName.text = offers[position].name
            tvMerchant.text = offers[position].merchant
            Glide.with(ivOffer).load(offers[position].image.url).into(ivOffer)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemOfferBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_offer, parent, false)
            )
        )

    override fun getItemCount(): Int = offers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind(position)
}