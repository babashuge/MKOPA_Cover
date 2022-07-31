package com.example.mkopaapp.ui.myAccount

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkopaapp.R
import com.example.mkopaapp.databinding.FragmentMyaccountBinding

import com.example.mkopaapp.ui.contactus.ContactusViewModel
import com.example.mkopaapp.ui.products.Phones
import com.example.mkopaapp.ui.products.PhonesAdapter
import com.example.mkopaapp.ui.products.ProductsFragmentDirections

class MyaccountFragment : Fragment(R.layout.fragment_myaccount) {

    private val viewModel by viewModels<MyaccountViewModel>()
    private var _binding: FragmentMyaccountBinding? = null
    private val binding get() = _binding!!

    private lateinit var productRecycler: RecyclerView
    private lateinit var accountproductList: ArrayList<Accountproducts>
    private lateinit var accountproductAdapter: AccountproductsAdapter
    private lateinit var accountprogressBar: ProgressBar


    lateinit var productImage : Array<Int>

//    lateinit var account_Name : Array<String>
//    lateinit var account_Number : Array<String>
//    lateinit var account_membersince : Array<String>
//    lateinit var account_totBalance : Array<String>
//    lateinit var account_totLastpay : Array<String>
//    lateinit var account_totLastamount : Array<String>


//    lateinit var productPrice : Array<String>
    lateinit var productprogress : Array<Int>
    lateinit var productName : Array<String>
    lateinit var productStatus : Array<String>
    lateinit var productNextamnt : Array<String>
//    lateinit var productDeadline : Array<String>
    lateinit var productNextpay : Array<String>



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accountprogressBar = view.findViewById(R.id.account_progressBar)
//        accountprogressBar = view.findViewById(R.id.accountproduct_progressBar)
        accountprogressBar.max = 100
        val currentProgress = 60

        ObjectAnimator.ofInt(accountprogressBar,"progress",currentProgress)
            .setDuration(2000)
            .start()

//        accountproductprogressBar.max = 100
//        val currentproductProgress = 60
//        ObjectAnimator.ofInt(accountproductprogressBar,"progress",currentproductProgress)
//            .setDuration(2000)
//            .start()


        accountproductList = arrayListOf<Accountproducts>()
        productprogress = arrayOf(
            10,56,100

            )

        productImage = arrayOf(
            R.drawable.phone_1,
            R.drawable.phone_2,
            R.drawable.phone_3,

        )
        productName = arrayOf(
            getString(R.string.phone1_name),
            getString(R.string.phone2_name),
            getString(R.string.phone3_name),

        )

        productStatus = arrayOf(
            getString(R.string.account_paystatus_active),
            getString(R.string.account_paystatus_locked),
            getString(R.string.account_paystatus_owned),

        )

        productNextamnt= arrayOf(
            getString(R.string.item_dailypay),
            getString(R.string.item_dailypay),
            getString(R.string.text_blanks),

        )

        productNextpay = arrayOf(
            getString(R.string.account_productnextpayin),
            getString(R.string.text_blanks),
            getString(R.string.text_blanks),

        )

        for (i in productImage.indices){
            val accountproducts = Accountproducts(productImage[i],productName[i],productStatus[i],productNextamnt[i],productNextpay[i],productprogress[i])
            accountproductList.add(accountproducts)
        }


        val layoutManager = LinearLayoutManager(context)
        productRecycler = view.findViewById(R.id.accounts_recycler)
        productRecycler.layoutManager = layoutManager
        productRecycler.setHasFixedSize(true)
        accountproductAdapter = AccountproductsAdapter(accountproductList)
        productRecycler.adapter = accountproductAdapter

        accountproductAdapter.setOnItemClickListener(object : AccountproductsAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                val action = MyaccountFragmentDirections.actionNavAccountToNavItemdetails(productName[position],productprogress[position],productStatus[position],productNextamnt[position],productNextpay[position],productImage[position],position)
                findNavController().navigate(action)



            }



    })
}
}