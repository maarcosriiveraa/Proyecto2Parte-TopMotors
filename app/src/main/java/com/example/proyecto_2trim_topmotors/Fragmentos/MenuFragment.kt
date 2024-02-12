package com.example.proyecto_2trim_topmotors.Fragmentos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.proyecto_2trim_topmotors.R
import com.example.proyecto_2trim_topmotors.databinding.FragmentMenu2Binding

class MenuFragment : Fragment() {
    private var _binding: FragmentMenu2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenu2Binding.inflate(inflater, container, false)
        val view = binding.root

        // Obtener nombre de usuario guardado en SharedPreferences
        val sharedPreferences = requireActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val nombreUsuario = sharedPreferences.getString("nombreUsuario", "")

        // Mostrar el nombre de usuario en el TextView
        if (!nombreUsuario.isNullOrEmpty()) {
            binding.TextoBienvenidaUsu.text = getString(R.string.textobienvenida, nombreUsuario)
        }

        // Configurar acciones de los botones
        binding.VerCoches.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_itemListFragment2)
        }
        binding.SalirApp.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_loginFragment)
        }
        binding.Creditos.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_creditFragment)
        }
        binding.botonmclaren.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_detailItemFragment)
        }
        binding.InfoUsuActual.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_userInfoFragment)
        }
        binding.Fav.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_favItemListFragment2)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
