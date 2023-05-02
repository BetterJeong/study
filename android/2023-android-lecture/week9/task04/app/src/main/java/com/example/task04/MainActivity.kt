package com.example.task04

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

class HomeFragment : Fragment(R.layout.home_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel : MyViewModel by activityViewModels()
        view.findViewById<TextView>(R.id.textView).text = viewModel.myValue.value

        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.myValue.value = (Integer.parseInt(viewModel.myValue.value.toString()) + 1).toString()
            findNavController().navigate(R.id.action_homeFragment_to_nav1Fragment)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        })
    }
}

class Nav1Fragment : Fragment(R.layout.nav1_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel : MyViewModel by activityViewModels()
        view.findViewById<TextView>(R.id.textView).text = viewModel.myValue.value

        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.myValue.value = (Integer.parseInt(viewModel.myValue.value.toString()) + 1).toString()
            findNavController().navigate(R.id.action_nav1Fragment_to_nav2Fragment)
        }
    }
}

class Nav2Fragment : Fragment(R.layout.nav2_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel : MyViewModel by activityViewModels()
        view.findViewById<TextView>(R.id.textView).text = viewModel.myValue.value

        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.myValue.value = (Integer.parseInt(viewModel.myValue.value.toString()) + 1).toString()
            findNavController().navigate(R.id.action_nav2Fragment_to_homeFragment)
        }
    }
}