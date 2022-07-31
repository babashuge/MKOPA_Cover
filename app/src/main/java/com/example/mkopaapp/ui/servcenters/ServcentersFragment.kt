package com.example.mkopaapp.ui.servcenters
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mkopaapp.R


class ServcentersFragment : Fragment(R.layout.fragment_servcenters) {

    private val viewModel by viewModels<ServcentersViewModel>()

    private lateinit var showstores: Button
    private lateinit var autoCompleteTextView: AutoCompleteTextView

    override fun onResume() {
        super.onResume()

        val servcenters = resources.getStringArray(R.array.servcenters)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.menu_drop,servcenters)
        autoCompleteTextView.setAdapter(arrayAdapter)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showstores = view.findViewById(R.id.button_showstores)
        autoCompleteTextView = view.findViewById(R.id.servcenters_autoCompleteTextView)


        showstores.setOnClickListener {

            requireActivity().run {
                Toast.makeText(this, "Opening maps", Toast.LENGTH_SHORT).show()
            }

            val shopsintent = Intent(Intent.ACTION_VIEW)
            shopsintent.data = Uri.parse(getString(R.string.servcenters_linkuganda))

            startActivity(shopsintent)
        }


        autoCompleteTextView.setOnClickListener {

            requireActivity().run {

                Toast.makeText(this, "Menuuuuuu", Toast.LENGTH_SHORT).show()
            }

        }
    }
}





