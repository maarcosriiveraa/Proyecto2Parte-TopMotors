package com.example.proyecto_2trim_topmotors.Fragmentos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.proyecto_2trim_topmotors.R
import com.example.proyecto_2trim_topmotors.databinding.FragmentUserInfoBinding

class UserInfoFragment : Fragment() {
    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        val view = binding.root

        // Recuperar nombre de usuario de SharedPreferences
        val sharedPreferences = requireActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val nombreusuario = sharedPreferences.getString("nombreUsuario", "")

        if (!nombreusuario.isNullOrEmpty()) {
            val textbienvenida = getString(R.string.usuactual, nombreusuario)
            binding.textViewName.text = textbienvenida
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        val message = "Datos Usuario Actual"
        val duration = Toast.LENGTH_SHORT
        val context = requireContext().applicationContext
        Toast.makeText(context, message, duration).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
