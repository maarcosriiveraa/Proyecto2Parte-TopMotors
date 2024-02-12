package com.example.proyecto_2trim_topmotors.Fragmentos

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proyecto_2trim_topmotors.R
import com.example.proyecto_2trim_topmotors.databinding.FragmentCreditBinding

class CreditFragment : Fragment() {

    private var _binding: FragmentCreditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreditBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnContactar.setOnClickListener {
            enviarCorreo()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun enviarCorreo() {
        val email = "marcosriveraoreal@gmail.com"
        val nombreApp = getString(R.string.app_name)
        val asunto = "Consulta de la app $nombreApp"

        val intentEmail = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")
            putExtra(Intent.EXTRA_SUBJECT, asunto)
        }


        if (intentEmail.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intentEmail)
        }
    }
}
