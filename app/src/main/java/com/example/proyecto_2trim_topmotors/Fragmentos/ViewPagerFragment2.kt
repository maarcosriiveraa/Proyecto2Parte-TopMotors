import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.proyecto_2trim_topmotors.R
import com.example.proyecto_2trim_topmotors.databinding.FragmentViewPager2Binding

class ViewPagerFragment2 : Fragment() {

    private var _binding: FragmentViewPager2Binding? = null
    private val binding get() = _binding!!

    private lateinit var videoView: VideoView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewPager2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        videoView = binding.videoView
        val videoPath = "android.resource://" + requireContext().packageName + "/" + R.raw.comienzo
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true
            mediaPlayer.start()
        }

        binding.btnComenzar.setOnClickListener {
            // Obtener el nombre de usuario del bundle
            val nombreUsuario = arguments?.getString("nombreUsuario")
            // Crear un bundle con el nombre de usuario
            val bundle = Bundle().apply {
                putString("nombreUsuario", nombreUsuario)
            }
            // Navegar al MenuFragment con el Bundle
            findNavController().navigate(R.id.action_viewPagerFragment_to_menuFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
