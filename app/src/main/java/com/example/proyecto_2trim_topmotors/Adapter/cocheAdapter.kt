import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_2trim_topmotors.Adapter.cocheViewHolder
import com.example.proyecto_2trim_topmotors.Coche
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
