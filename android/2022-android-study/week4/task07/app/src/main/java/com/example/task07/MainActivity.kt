package com.example.task07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task07.databinding.ActivityMainBinding
import com.example.task07.databinding.ItemDialogLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar

class ItemDialog(val clickedItemPos:Int = -1) : BottomSheetDialogFragment() {

    private lateinit var binding: ItemDialogLayoutBinding

    private val viewModel by activityViewModels<MyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  ItemDialogLayoutBinding.inflate(inflater, container, false)
        return binding.root
        //return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, names)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter

        if(clickedItemPos >= 0) {
            val n = viewModel.items[clickedItemPos].name
            val s = names.indexOf(n)
            binding.spinner.setSelection(s)

            binding.editTextPhone.setText(viewModel.items[clickedItemPos].phone)
        } else {
            binding.spinner.setSelection(0)
        }

        binding.buttonOK.setOnClickListener {
            val name = binding.spinner.selectedItem as String
            val item = Item(name, binding.editTextPhone.text.toString())
            if (clickedItemPos < 0) {
                viewModel.addItem(item)
            } else {
                viewModel.updateItem(item, clickedItemPos)
            }
            dismiss()
        }
    }

    companion object {
        val names = arrayListOf("james", "tom", "jane")
    }

}

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            //Snackbar.make(it, "TEST", Snackbar.LENGTH_SHORT).show()
            ItemDialog().show(supportFragmentManager, "ItemDialog")
        }

        val adapter = CustomAdapter(viewModel)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

        viewModel.itemsLiveData.observe(this) {
            //adapter.notifyDataSetChanged()
            adapter.notifyItemChanged(viewModel.changedItemPos)
        }

        // 1. register for context menu
        registerForContextMenu(binding.recyclerView)
    }

    // 2.
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.ctx_menu, menu)
    }

    // 3.
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.edit -> ItemDialog(viewModel.longClickItem).show(supportFragmentManager, "ItemDialog")
            R.id.delete -> println("Delete ${viewModel.longClickItem}")
            else -> super.onContextItemSelected(item)
        }
        return true
    }
}