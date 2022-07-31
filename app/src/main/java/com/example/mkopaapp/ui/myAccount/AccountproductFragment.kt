package com.example.mkopaapp.ui.myAccount

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

class AccountproductFragment : Fragment(R.layout.fragment_accountitemdetails) {



    val args: AccountproductFragmentArgs by navArgs()
    private lateinit var payNow: Button

    private lateinit var accountproductImage: ImageView
    private lateinit var accountproductName: TextView
    private lateinit var accountproductStatus: TextView
    private lateinit var accountproductLoan: TextView
    private lateinit var accountproductProgress: ProgressBar
    private lateinit var accountproductBalance: TextView
    private lateinit var accountproductNextpaydate: TextView
    private lateinit var accountproductNextamnt: TextView
    private lateinit var accountproductLastpaydate: TextView
    private lateinit var accountproductLastamnt: TextView

    lateinit var productloan_array: Array<String>
    lateinit var productbal_array: Array<String>
    lateinit var productlastamnt_array: Array<String>
    lateinit var productlastdate_array: Array<String>






    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        accountproductName = view.findViewById(R.id.account_productname)
        accountproductImage = view.findViewById(R.id.account_productimage)
        accountproductStatus = view.findViewById(R.id.account_productstatus)
        accountproductLoan = view.findViewById(R.id.account_productloan)
        accountproductProgress = view.findViewById(R.id.account_productprogress)
        accountproductBalance = view.findViewById(R.id.account_productbalance)
        accountproductNextpaydate = view.findViewById(R.id.account_productnextpay)
        accountproductNextamnt = view.findViewById(R.id.account_productnextamnt)
        accountproductLastpaydate = view.findViewById(R.id.account_productlastpaydate)
        accountproductLastamnt = view.findViewById(R.id.account_productlastamnt)


        productloan_array = arrayOf(
            getString(R.string.phone1_price),
            getString(R.string.phone2_price),
            getString(R.string.phone3_price),
            getString(R.string.phone1_price),
            getString(R.string.phone2_price),
            getString(R.string.phone3_price)
        )

        productlastamnt_array = arrayOf(
            getString(R.string.item_dailypay),
            getString(R.string.item_dailypay),
            getString(R.string.item_dailypay),
            getString(R.string.item_dailypay),
            getString(R.string.item_dailypay),
            getString(R.string.item_dailypay)
        )
        productlastdate_array = arrayOf(
            getString(R.string.account_lastpaydate),
            getString(R.string.account_lastpaydate),
            getString(R.string.account_lastpaydate),
            getString(R.string.account_lastpaydate),
            getString(R.string.account_lastpaydate),
            getString(R.string.account_lastpaydate)

        )

        productbal_array = arrayOf(
            getString(R.string.account_productbalance),
            getString(R.string.account_productbalance),
            getString(R.string.text_blanks),
            getString(R.string.account_productbalance),
            getString(R.string.account_productbalance),
            getString(R.string.text_blanks)
        )

        accountproductName.setText(args.argAccountproductName)
        accountproductStatus.setText(args.argAccountproductStatus)
        accountproductLoan.setText(productloan_array[args.argAccountproductSelection])
        accountproductProgress.setProgress(args.argAccountproductProgress)
        accountproductBalance.setText(productbal_array[args.argAccountproductSelection])
        accountproductImage.setImageResource(args.argAccountproductImage)
        accountproductNextamnt.setText(args.argAccountproductNextamnt)
        accountproductNextpaydate.setText(args.argAccountproductNextdate)
        accountproductLastamnt.setText(productlastamnt_array[args.argAccountproductSelection])
        accountproductLastpaydate.setText(productlastdate_array[args.argAccountproductSelection])


        payNow = view.findViewById(R.id.account_payButton)

        payNow.setOnClickListener {

            val action = AccountproductFragmentDirections.actionNavAccountitemdetailsToNavPaymentsform(args.argAccountproductName,args.argAccountproductProgress,args.argAccountproductStatus,args.argAccountproductNextamnt,args.argAccountproductImage)
            findNavController().navigate(action)

        }


    }
}