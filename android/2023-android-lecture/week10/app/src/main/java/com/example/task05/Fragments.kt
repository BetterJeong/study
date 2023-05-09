package com.example.task05

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

class MyDialogFragments : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //return super.onCreateDialog(savedInstanceState)
        isCancelable = false
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("2171110")
        builder.setMessage("나은정")
        builder.setPositiveButton("OK") { dialog, id -> println("OK") }
        return builder.create()

        /* return AlertDialog.Builder(requireActivity()).apply {
            setMessage("Dialog Message")
            setPositiveButton("OK") { dialog, id -> println("OK") }
        }.create() */
    }
}

class Home : Fragment(R.layout.fragment_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.textView).text = "Home"
    }
}

class Frag1 : Fragment(R.layout.fragment_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.textView).text = "Page1Fragment"
    }
}

class Frag2 : Fragment(R.layout.fragment_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.textView).text = "Page2Fragment"
    }
}