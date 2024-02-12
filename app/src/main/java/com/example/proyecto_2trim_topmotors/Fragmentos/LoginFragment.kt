package com.example.proyecto_2trim_topmotors.Fragmentos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.proyecto_2trim_topmotors.R
import com.example.proyecto_2trim_topmotors.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.buttonLogin.setOnClickListener {
            val nombreUsuario = binding.editTextUsername.text.toString()

            if (nombreUsuario.isNotEmpty()) {
                // Guardar nombre de usuario en SharedPreferences
                val sharedPreferences = requireActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
                with(sharedPreferences.edit()) {
                    putString("nombreUsuario", nombreUsuario)
                    apply()
                }

                // Navegar al MenuFragment
                findNavController().navigate(R.id.action_loginFragment_to_viewPagerFragment)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
