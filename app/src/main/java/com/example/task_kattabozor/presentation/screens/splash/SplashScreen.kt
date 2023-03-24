package com.example.task_kattabozor.presentation.screens.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.task_kattabozor.R
import com.example.task_kattabozor.presentation.screens.splash.viewmodel.SplashViewModel
import com.example.task_kattabozor.presentation.screens.splash.viewmodel.SplashViewModelImp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreen : Fragment(R.layout.screen_splash) {
private val vm: SplashViewModel by viewModels<SplashViewModelImp>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
vm.apply { moveToOffersScreenLiveData.observe(viewLifecycleOwner,moveToOffersScreenObserver) }
    }
private val moveToOffersScreenObserver = Observer<Unit>{findNavController().navigate(R.id.action_splashScreen_to_offersScreen)}}