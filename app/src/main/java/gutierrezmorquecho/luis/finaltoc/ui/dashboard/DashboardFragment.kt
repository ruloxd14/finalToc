package gutierrezmorquecho.luis.finaltoc.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import gutierrezmorquecho.luis.finaltoc.Horario_dia
import gutierrezmorquecho.luis.finaltoc.Horario_semana
import gutierrezmorquecho.luis.finaltoc.Material_extra_arte_actividades
import gutierrezmorquecho.luis.finaltoc.R
import gutierrezmorquecho.luis.finaltoc.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        root.findViewById<Button>(R.id.botonsemana1)?.setOnClickListener {
            val myIntent = Intent(activity, Horario_semana::class.java)
            requireActivity().startActivity(myIntent)
        }
        root.findViewById<Button>(R.id.botonsemana2)?.setOnClickListener {
            val myIntent = Intent(activity, Horario_semana::class.java)
            requireActivity().startActivity(myIntent)
        }
        root.findViewById<Button>(R.id.botonsemana3)?.setOnClickListener {
            val myIntent = Intent(activity, Horario_semana::class.java)
            requireActivity().startActivity(myIntent)
        }
        root.findViewById<Button>(R.id.botonsemana4)?.setOnClickListener {
            val myIntent = Intent(activity, Horario_semana::class.java)
            requireActivity().startActivity(myIntent)
        }

        root.findViewById<Button>(R.id.botonsemana5)?.setOnClickListener {
            val myIntent = Intent(activity, Horario_semana::class.java)
            requireActivity().startActivity(myIntent)
        }


        //val textView: TextView = binding.textDashboard
        //dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            //textView.text = it
        //})
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}