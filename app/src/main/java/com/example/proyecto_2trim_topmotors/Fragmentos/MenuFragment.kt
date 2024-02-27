package com.example.proyecto_2trim_topmotors.Fragmentos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyecto_2trim_topmotors.R
import com.example.proyecto_2trim_topmotors.databinding.ActivityMainBinding
import com.example.proyecto_2trim_topmotors.databinding.FragmentMenu2Binding
import com.google.android.material.bottomnavigation.BottomNavigationView



class MenuFragment : Fragment() {
    private var _binding: FragmentMenu2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenu2Binding.inflate(inflater, container, false)
        val view = binding.root
        binding.Creditos.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_creditFragment)
        }
        binding.SalirApp.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_loginFragment)
        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
