import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proyecto_2trim_topmotors.databinding.ActivityMainBinding
import com.example.proyecto_2trim_topmotors.databinding.FragmentViewPager1Binding

class ViewPagerFragment1 : Fragment() {

    private var _binding: FragmentViewPager1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewPager1Binding.inflate(inflater, container, false)


        // Hacer el BottomNavigationView invisible


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
