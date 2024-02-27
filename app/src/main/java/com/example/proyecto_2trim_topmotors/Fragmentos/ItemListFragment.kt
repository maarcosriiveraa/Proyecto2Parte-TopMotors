import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_2trim_topmotors.CocheProvider
import com.example.proyecto_2trim_topmotors.R
import com.example.proyecto_2trim_topmotors.databinding.FragmentItemListBinding

class ItemListFragment : Fragment() {
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var sharedPreferences: SharedPreferences
    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!

    private var isFirstTime: Boolean
        get() = sharedPreferences.getBoolean("isFirstTime", true)
        set(value) = sharedPreferences.edit().putBoolean("isFirstTime", value).apply()

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)

        if (isFirstTime) {
            isFirstTime = false
        }

        // Obtener el NavController
        navController = findNavController()

        // Configurar BottomNavigationView con NavController


        binding.btnfavorito.setOnClickListener {
            guardarElementosSeleccionados()
        }

        // Configurar RecyclerView
        iniciarRecyclerView()

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        val message = "Lista SuperCoches"
        val duration = Toast.LENGTH_SHORT
        val context = requireContext().applicationContext
        Toast.makeText(context, message, duration).show()
    }

    private fun iniciarRecyclerView() {
        val recyclerView = binding.recyclerCoches
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = CocheAdapter(CocheProvider.listaCoches)
    }

    private fun guardarElementosSeleccionados() {
        val adapter = binding.recyclerCoches.adapter as CocheAdapter
        val elementosSeleccionados = adapter.getSelectedCoches()

        // Guardar la lista de elementos seleccionados en el ViewModel compartido
        sharedViewModel.elementosSeleccionados.value = elementosSeleccionados
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
