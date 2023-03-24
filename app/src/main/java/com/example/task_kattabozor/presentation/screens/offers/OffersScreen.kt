package com.example.task_kattabozor.presentation.screens.offers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.task_kattabozor.R
import com.example.task_kattabozor.data.network.models.Offer
import com.example.task_kattabozor.databinding.ScreenOffersBinding
import com.example.task_kattabozor.presentation.adapter.OffersAdapter
import com.example.task_kattabozor.presentation.screens.offers.viewmodel.OffersViewModel
import com.example.task_kattabozor.presentation.screens.offers.viewmodel.OffersViewModelImp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OffersScreen : Fragment(R.layout.screen_offers) {
    private val binding by viewBinding(ScreenOffersBinding::bind)
    private val vm: OffersViewModel by viewModels<OffersViewModelImp>()
    private lateinit var adapter: OffersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.moveToInfoScreenLiveData.observe(this, moveToInfoScreenObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vm.apply {
            offersLiveData.observe(viewLifecycleOwner, offersObserver)
        }
        initAdapter()
    }

    private fun initAdapter() {
        adapter = OffersAdapter()
        adapter.setClickListener { vm.selectOffer(it) }
        binding.rvOffers.layoutManager = LinearLayoutManager(requireContext())
        binding.rvOffers.adapter = adapter
    }

    private val offersObserver = Observer<List<Offer>> { adapter.submitList(it) }
    private val moveToInfoScreenObserver = Observer<Offer> {
        val direction = OffersScreenDirections.actionOffersScreenToInfoScreen(it.id)
        findNavController().navigate(direction)
    }
}