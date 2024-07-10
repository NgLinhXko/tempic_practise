package com.example.tempic_practice.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tempic_practice.databinding.RegisterAgreeSaveInfoBinding

class RegisterAgreeSaveInfo : Fragment() {
    private lateinit var binding: RegisterAgreeSaveInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegisterAgreeSaveInfoBinding.inflate(layoutInflater)
        return binding.root
    }
}