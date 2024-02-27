import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_2trim_topmotors.Coche
import com.example.proyecto_2trim_topmotors.R
import com.example.proyecto_2trim_topmotors.databinding.FragmentFavItemListBinding

class FavItemListFragment : Fragment() {
    private lateinit var sharedViewModel: SharedViewModel
    private var _binding: FragmentFavItemListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CocheAdapter
    private val favoritosList = mutableListOf<Coche>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavItemListBinding.inflate(inflater, container, false)

        // Configurar RecyclerView
        iniciarRecyclerView()

        // Inicializar ViewModel
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        // Observar cambios en la lista de elementos seleccionados
        sharedViewModel.elementosSeleccionados.observe(viewLifecycleOwner) { elementosSeleccionados ->
            agregarFavoritos(elementosSeleccionados)
        }

        // Configurar el OnClickListener para el botón de eliminar


        return binding.root
    }

    private fun iniciarRecyclerView() {
        adapter = CocheAdapter(favoritosList)
        binding.recyclerCoches.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerCoches.adapter = adapter
    }

    private fun agregarFavoritos(coches: List<Coche>) {
        // Agregar solo los nuevos elementos de la lista de elementos seleccionados a la lista de favoritos
        favoritosList.addAll(coches)
        // Notificar al adaptador que se han agregado nuevos elementos a la lista de favoritos
        adapter.notifyDataSetChanged()
    }

    private fun eliminarElementoSeleccionado() {
        // Obtener la posición del elemento seleccionado para eliminar
        val posicionAEliminar = obtenerPosicionAEliminar()

        // Verificar si la posición es válida y eliminar el elemento de la lista de favoritos
        if (posicionAEliminar != RecyclerView.NO_POSITION) {
            favoritosList.removeAt(posicionAEliminar)
            // Notificar al adaptador que se ha eliminado un elemento de la lista de favoritos
            adapter.notifyItemRemoved(posicionAEliminar)
        }
    }


    private fun obtenerPosicionAEliminar(): Int = 0

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}