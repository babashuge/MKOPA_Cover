package com.example.mkopaapp.ui.products

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
import com.example.mkopaapp.ui.howto.GuideviewFragmentArgs
import com.example.mkopaapp.ui.languages.LanguagesViewModel

class ProductitemFragment : Fragment(R.layout.fragment_productitemdetails) {



    val args: ProductitemFragmentArgs by navArgs()
    private lateinit var declareInterest: Button
    private lateinit var itemImage: ImageView
    private lateinit var itemDetails: TextView
    private lateinit var itemDaily: TextView
    private lateinit var itemMonthly: TextView
    private lateinit var itemWeekly: TextView
    private lateinit var itemName: TextView
    private lateinit var itemCost: TextView
    private lateinit var itemDepo: TextView


    lateinit var phoneDetails: Array<String>
    lateinit var phoneDepo: Array<String>
    lateinit var monthlyInst: Array<String>
    lateinit var weeklyInst: Array<String>



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        declareInterest = view.findViewById(R.id.item_interestButton)
        declareInterest.setOnClickListener {
            requireActivity().run {
                Toast.makeText(this, "Opens Chat with lead gen options ", Toast.LENGTH_SHORT).show()
            }
        }


        itemDetails = view.findViewById(R.id.item_details)
        itemImage = view.findViewById(R.id.item_image)
        itemName = view.findViewById(R.id.item_name)
        itemCost = view.findViewById(R.id.item_cost)
        itemDepo = view.findViewById(R.id.item_deposit)
        itemDaily = view.findViewById(R.id.item_dailypay)
        itemWeekly = view.findViewById(R.id.item_weeklypay)
        itemMonthly = view.findViewById(R.id.item_monthlypay)

        phoneDetails = arrayOf(
            getString(R.string.phone1_details),
            getString(R.string.phone2_details),
            getString(R.string.phone3_details),
            getString(R.string.phone1_details),
            getString(R.string.phone2_details),
            getString(R.string.phone3_details)
        )

        phoneDepo = arrayOf(
            getString(R.string.phone1_depo),
            getString(R.string.phone2_depo),
            getString(R.string.phone3_depo),
            getString(R.string.phone1_depo),
            getString(R.string.phone2_depo),
            getString(R.string.phone3_depo)
        )
        weeklyInst = arrayOf(
            getString(R.string.phone1_weeklyinst),
            getString(R.string.phone2_weeklyinst),
            getString(R.string.phone3_weeklyinst),
            getString(R.string.phone1_weeklyinst),
            getString(R.string.phone2_weeklyinst),
            getString(R.string.phone3_weeklyinst)
        )
        monthlyInst = arrayOf(
            getString(R.string.phone1_monthlyinst),
            getString(R.string.phone2_monthlyinst),
            getString(R.string.phone3_monthlyinst),
            getString(R.string.phone1_monthlyinst),
            getString(R.string.phone2_monthlyinst),
            getString(R.string.phone3_monthlyinst)
        )

        itemDetails.setText(phoneDetails[args.argPhoneselection])
        itemImage.setImageResource(args.argPhoneimage)
        itemCost.setText(args.argPhonecost)
        itemName.setText(args.argPhonename)
        itemDaily.setText(args.argDailypay)
        itemMonthly.setText(monthlyInst[args.argPhoneselection])
        itemWeekly.setText(weeklyInst[args.argPhoneselection])
        itemDepo.setText(phoneDepo[args.argPhoneselection])








    }
}