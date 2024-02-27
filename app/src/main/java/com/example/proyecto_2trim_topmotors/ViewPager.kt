import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proyecto_2trim_topmotors.databinding.ActivityMainBinding

import com.example.proyecto_2trim_topmotors.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!
    private var _binding2: ActivityMainBinding? = null
    private val binding2 get() = _binding2!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val view = binding.root


        val adapter = ViewPagerAdapter(requireActivity())
        binding.pager.adapter = adapter

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
