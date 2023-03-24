package com.example.task_kattabozor.presentation.screens.info

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.task_kattabozor.R
import com.example.task_kattabozor.data.network.models.Offer
import com.example.task_kattabozor.databinding.ScreenInfoBinding
import com.example.task_kattabozor.presentation.adapter.AttributeAdapter
import com.example.task_kattabozor.presentation.screens.info.viewmodel.InfoViewModel
import com.example.task_kattabozor.presentation.screens.info.viewmodel.InfoViewModelImp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoScreen : Fragment(R.layout.screen_info) {
    private val args: InfoScreenArgs by navArgs()
    private val binding by viewBinding(ScreenInfoBinding::bind)
    private val vm: InfoViewModel by viewModels<InfoViewModelImp>()
    private lateinit var adapter: AttributeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vm.loadOffer(args.offerId)
        vm.currentOfferLiveData.observe(viewLifecycleOwner, currentOfferObserver)
        vm.moveToBackLiveData.observe(viewLifecycleOwner, moveToBackObserver)
        initRv()
    }

    private fun initRv() {
        adapter = AttributeAdapter()
        binding.rvAttributes.adapter = adapter
    }

    private val currentOfferObserver = Observer<Offer> {
        binding.apply {
            btBack.setOnClickListener { vm.clickBack() }
            Glide.with(requireContext()).load(it.image.url).into(ivOffer)
            tvName.text = it.name
            tvBrand.text = it.brand
            tvCategory.text = it.category
            tvMerchant.text = it.merchant
            adapter.submitList(it.attributes)
        }

    }
    private val moveToBackObserver = Observer<Unit> {
        findNavController().popBackStack()
    }
}