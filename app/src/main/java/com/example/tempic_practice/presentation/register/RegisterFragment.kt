package com.example.tempic_practice.presentation.register

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tempic_practice.R
import com.example.tempic_practice.common.getStringApp
import com.example.tempic_practice.common.setSpannableText
import com.example.tempic_practice.databinding.RegisterFragmentBinding

class RegisterFragment : Fragment() {
    private lateinit var binding: RegisterFragmentBinding
    private lateinit var context: Context
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        context = requireContext()
        binding = RegisterFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvTitleRegister.setSpannableText(
            text = getStringApp(stringResId = R.string.title_register).toString(),
            lengthStart = getStringApp(stringResId = R.string.start_text).toString().length,
            lengthAll = getStringApp(stringResId = R.string.title_register).toString().length,
            fontStart = Typeface.BOLD
        )
    }
}
