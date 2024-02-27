import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.proyecto_2trim_topmotors.CocheProvider
import com.example.proyecto_2trim_topmotors.databinding.FragmentDetailItemBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.squareup.picasso.Picasso

class DetailItemFragment : Fragment() {
    private var _binding: FragmentDetailItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailItemBinding.inflate(inflater, container, false)
        val view = binding.root

        // Obtener el itemId del argumento
        val itemId = arguments?.getInt("itemId")
        Log.d("DetailItemFragment", "Item ID: $itemId")

        // Buscar el coche correspondiente en el CocheProvider
        val coche = CocheProvider.listaCoches.find { it.itemId == itemId }

        // Mostrar los datos del coche si se encontró
        if (coche != null) {
            binding.tvTitulo.text = coche.marca
            binding.tvTipo.text = coche.motor
            binding.tvModelo.text = coche.modelo
            binding.tvPotencia.text = coche.potencia
            Picasso.get().load(coche.imagen).into(binding.ivCoche)

            // Cargar el video de YouTube si hay una URL proporcionada en CocheProvider
            if (!coche.youtubeVideoId.isNullOrEmpty()) {
                initializeYouTubePlayer(coche.youtubeVideoId)
            }
        } else {
            Log.e("DetailItemFragment", "Coche no encontrado para el ID: $itemId")
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeYouTubePlayer(youtubeVideoUrl: String) {
        // Inicializar y configurar el reproductor de YouTube
        binding.youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer) {
                youTubePlayer.loadVideo(getYouTubeVideoId(youtubeVideoUrl), 0f)
            }
        })
    }

    private fun getYouTubeVideoId(youtubeVideoUrl: String): String {
        val videoId = youtubeVideoUrl.substringAfterLast("v=")
        return videoId
    }
}