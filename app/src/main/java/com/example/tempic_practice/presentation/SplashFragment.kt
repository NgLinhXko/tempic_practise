package com.example.tempic_practice.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tempic_practice.databinding.SplashFragmentBinding

class SplashFragment : Fragment() {
    private lateinit var binding: SplashFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SplashFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val widthScreen = resources.displayMetrics.widthPixels
        val ivSplash = binding.ivSplash
        val params = ivSplash.layoutParams
        params.width = (widthScreen * 0.58).toInt()
        ivSplash.layoutParams = params
        super.onViewCreated(view, savedInstanceState)
    }
}