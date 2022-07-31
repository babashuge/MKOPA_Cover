package com.example.mkopaapp.ui.languages

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mkopaapp.R
import com.example.mkopaapp.databinding.FragmentLangsBinding
import com.example.mkopaapp.ui.home.HomeFragment
import com.example.mkopaapp.ui.home.HomeViewModel
import com.example.mkopaapp.ui.products.ProductsViewModel

class LanguagesFragment : Fragment(R.layout.fragment_langs) {


    private val viewModel by viewModels<LanguagesViewModel>()
    private var _binding: FragmentLangsBinding? = null

    private lateinit var langsConfirm: Button
    private lateinit var langsCancel: Button
    private lateinit var autoCompleteTextView: AutoCompleteTextView



    override fun onResume() {
        super.onResume()

        val languages = resources.getStringArray(R.array.languages)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.menu_drop,languages)
        autoCompleteTextView.setAdapter(arrayAdapter)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        langsConfirm = view.findViewById(R.id.button_langconfirm)
        langsCancel = view.findViewById(R.id.button_langcancel)
        autoCompleteTextView = view.findViewById(R.id.langs_autoCompleteTextView)



        langsConfirm.setOnClickListener {
            findNavController().navigate(R.id.action_nav_changelang_to_nav_home)
            requireActivity().run {
                Toast.makeText(this, "Language Confirmed", Toast.LENGTH_SHORT).show()
            }
        }

        langsCancel.setOnClickListener {
            findNavController().navigate(R.id.action_nav_changelang_to_nav_home)
            requireActivity().run {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            }
        }

        autoCompleteTextView.setOnClickListener {

            requireActivity().run {

                Toast.makeText(this, "Menuuuuuu", Toast.LENGTH_SHORT).show()
            }

        }
    }
}