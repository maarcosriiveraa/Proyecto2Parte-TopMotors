import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyecto_2trim_topmotors.Coche

class SharedViewModel : ViewModel() {
    val elementosSeleccionados = MutableLiveData<List<Coche>>()
}
