package com.example.mkopaapp.ui.payments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mkopaapp.R
import com.example.mkopaapp.databinding.FragmentContactusBinding
import com.example.mkopaapp.ui.languages.LanguagesViewModel
import com.example.mkopaapp.ui.products.ProductitemFragmentArgs

class PaymentsformFragment : Fragment(R.layout.fragment_pay_form) {



    val args: PaymentsformFragmentArgs by navArgs()
    private lateinit var payNow: Button

    private lateinit var paymentsproductImage: ImageView
    private lateinit var paymentsproductName: TextView
    private lateinit var paymentsproductStatus: TextView
    private lateinit var paymentsproductProgress: ProgressBar
    private lateinit var paymentsproductNextamnt: EditText


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        paymentsproductName = view.findViewById(R.id.payments_productname)
        paymentsproductImage = view.findViewById(R.id.payments_productimage)
        paymentsproductStatus = view.findViewById(R.id.payments_productstatus)
        paymentsproductProgress = view.findViewById(R.id.payments_productprogress)
        paymentsproductNextamnt = view.findViewById(R.id.payments_amntfield)


        paymentsproductName.setText(args.argAccountproductName)
        paymentsproductStatus.setText(args.argAccountproductStatus)
        paymentsproductProgress.setProgress(args.argAccountproductProgress)
        paymentsproductImage.setImageResource(args.argAccountproductImage)
        paymentsproductNextamnt.setText(args.argAccountproductNextamnt)

        payNow = view.findViewById(R.id.payments_payButton)

        payNow.setOnClickListener {
            findNavController().navigate(R.id.action_nav_paymentsform_to_nav_payments_processing)
        }


    }
}