package com.example.mkopaapp.ui.payments
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mkopaapp.R


class PaymentsprocessingFragment : Fragment(R.layout.fragment_pay_processing) {

    private val viewModel by viewModels<PaymentsViewModel>()

    private lateinit var payDone: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        payDone = view.findViewById(R.id.payments_doneButton)

        payDone.setOnClickListener {
            requireActivity().run {
                Toast.makeText(this, "Refreshing account details", Toast.LENGTH_SHORT).show()
            }
            findNavController().navigate(R.id.action_nav_payments_processing_to_nav_home)
        }
    }
}