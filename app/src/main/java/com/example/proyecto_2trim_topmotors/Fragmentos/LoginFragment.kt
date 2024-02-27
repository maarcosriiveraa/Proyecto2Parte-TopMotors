package com.example.proyecto_2trim_topmotors.Fragmentos

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.navigation.fragment.findNavController
import com.example.proyecto_2trim_topmotors.Actividades.MainActivity
import com.example.proyecto_2trim_topmotors.R
import com.example.proyecto_2trim_topmotors.databinding.FragmentLoginBinding
import java.util.Locale

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Cargar preferencias de idioma
        val sharedPreferences = requireActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE)

        // Llama al método languageMode para configurar el interruptor de idioma
        languageMode()

        binding.buttonLogin.setOnClickListener {
            val nombreUsuario = binding.editTextUsername.text.toString()

            if (nombreUsuario.isNotEmpty()) {
                // Guardar nombre de usuario en SharedPreferences
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

    private fun languageMode() {
        //Añadido
        val sharedPreferences = activity?.getSharedPreferences("MODE", Context.MODE_PRIVATE)
        val languagePreference = sharedPreferences?.getString("LANGUAGE", "en-EN")

        // Verifica el idioma actual de la aplicación e inicializa el interruptor en la posición correspondiente
        binding.languageSwitch.isChecked = languagePreference == "es-ES"

        binding.languageSwitch.setOnCheckedChangeListener { _, isChecked ->
            val newLanguage = if (isChecked) "es-ES" else "en-EN"

            // Actualiza el idioma de la aplicación
            val appLocale: LocaleListCompat =
                LocaleListCompat.forLanguageTags(newLanguage)
            AppCompatDelegate.setApplicationLocales(appLocale)

            // Guarda la preferencia para futuros usos
            with(sharedPreferences?.edit()) {
                this?.putString("LANGUAGE", newLanguage)
                this?.apply()
            }
        }
    }
}
