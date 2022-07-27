package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myapplication.databinding.FragmentHomeBinding
import kotlinx.coroutines.isActive

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    val homeViewModel: HomeViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("navtest: HOMEFRAGMENT.ONCREATE")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        println("navtest: HOMEFRAGMENT.ONCREATEVIEW")
        println("navtest: ${homeViewModel} VIEWMODEL.isactive = ${homeViewModel.viewModelScope.isActive}")

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        val button = binding.myButton
        button.setOnClickListener {
            homeViewModel.callHomePageResolver()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("navtest: HOMEFRAGMENT.ONDESTROYVIEW")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        println("navtest: HOMEFRAGMENT.ONDESTROY")
    }
}