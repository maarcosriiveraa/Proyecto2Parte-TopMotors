package com.example.proyecto_2trim_topmotors.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyecto_2trim_topmotors.Coche
import com.example.proyecto_2trim_topmotors.R
import com.example.proyecto_2trim_topmotors.databinding.ItemcocheBinding

class cocheViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemcocheBinding.bind(view)
    fun render(CocheModel: Coche) {
        binding.tvCocheName.text = CocheModel.marca
        binding.tvTipo.text = CocheModel.motor
        binding.tvcochecaballos.text = CocheModel.modelo
        binding.tvSiguienteDato.text = CocheModel.potencia
        Glide.with(binding.ivcoche.context).load(CocheModel.imagen).into(binding.ivcoche)
        // Cambiar el color de fondo dependiendo del estado de selección
        if (CocheModel.isSelected) {
            binding.root.setBackgroundResource(R.color.black)
        } else {
            binding.root.setBackgroundResource(android.R.color.transparent)
        }
    }

}