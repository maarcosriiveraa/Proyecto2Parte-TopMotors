import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_2trim_topmotors.Adapter.cocheViewHolder
import com.example.proyecto_2trim_topmotors.Coche
import com.example.proyecto_2trim_topmotors.CocheProvider.Companion.listaCoches
import com.example.proyecto_2trim_topmotors.R
import com.example.proyecto_2trim_topmotors.databinding.ItemcocheBinding

class CocheAdapter(private val cocheList: List<Coche>) : RecyclerView.Adapter<cocheViewHolder>() {

    private val selectedCoches = mutableListOf<Coche>()

    // Método para obtener los coches seleccionados
    fun getSelectedCoches(): List<Coche> {
        return selectedCoches
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cocheViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemcocheBinding.inflate(layoutInflater, parent, false)
        val view = binding.root // Obtener la vista raíz del binding
        return cocheViewHolder(view)
    }

    override fun getItemCount(): Int = cocheList.size

    override fun onBindViewHolder(holder: cocheViewHolder, position: Int) {
        val item = cocheList[position]
        holder.render(item)
        holder.binding.btnDetalle.setOnClickListener {
            // Obtener el ID del elemento seleccionado
            val itemId = listaCoches[holder.adapterPosition].itemId

            // Crear un Bundle para pasar el itemId al fragmento de detalle
            val bundle = bundleOf("itemId" to itemId)

            // Navegar al fragmento de detalle y pasar el Bundle
            it.findNavController().navigate(R.id.action_itemListFragment2_to_detailItemFragment, bundle)
        }


        holder.itemView.setOnClickListener {
            item.isSelected = !item.isSelected
            if (item.isSelected) {
                selectedCoches.add(item)
            } else {
                selectedCoches.remove(item)
            }
            notifyItemChanged(position)
        }
    }

}