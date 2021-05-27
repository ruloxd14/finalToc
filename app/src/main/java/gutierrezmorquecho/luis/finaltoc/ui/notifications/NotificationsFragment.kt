package gutierrezmorquecho.luis.finaltoc.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import gutierrezmorquecho.luis.finaltoc.*
import gutierrezmorquecho.luis.finaltoc.databinding.FragmentNotificationsBinding
import kotlinx.android.synthetic.main.fragment_notifications.*
import kotlinx.android.synthetic.main.fragment_notifications.view.*


class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        root.findViewById<Button>(R.id.botonarte)?.setOnClickListener {
            val myIntent = Intent(activity, Material_extra_arte_actividades::class.java)
            requireActivity().startActivity(myIntent)
        }
        root.findViewById<Button>(R.id.botonocio)?.setOnClickListener {
            val myIntent = Intent(activity, Material_extra_ocio_actividades::class.java)
            requireActivity().startActivity(myIntent)
        }
        root.findViewById<Button>(R.id.botonlectura)?.setOnClickListener {
            val myIntent = Intent(activity, Material_extra_lectura_actividades::class.java)
            requireActivity().startActivity(myIntent)
        }
        root.findViewById<Button>(R.id.botonfisico)?.setOnClickListener {
            val myIntent = Intent(activity, Material_extra_fisico_actividades::class.java)
            requireActivity().startActivity(myIntent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}