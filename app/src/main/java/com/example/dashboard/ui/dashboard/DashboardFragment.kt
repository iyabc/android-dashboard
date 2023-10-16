package com.example.dashboard.ui.dashboard

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dashboard.MainActivity
import com.example.dashboard.QPIActivity
import com.example.dashboard.R
import com.example.dashboard.ThirdActivity
import com.example.dashboard.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputBtn = view.findViewById<Button>(R.id.input_button)
        val qpiBtn = view.findViewById<Button>(R.id.qpi_button)

        inputBtn.setOnClickListener {
            activity?.let {
                val inputScreen = Intent(it, ThirdActivity::class.java)
                it.startActivity(inputScreen)
            }
        }

        qpiBtn.setOnClickListener {
            activity?.let {
                val qpiScreen = Intent(it, QPIActivity::class.java)
                it.startActivity(qpiScreen)
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}