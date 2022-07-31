package com.example.mkopaapp.ui.howto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkopaapp.R
import com.example.mkopaapp.databinding.FragmentHowtoBinding
import com.example.mkopaapp.ui.myAccount.Accountproducts
import com.example.mkopaapp.ui.myAccount.AccountproductsAdapter
import com.example.mkopaapp.ui.myAccount.MyaccountViewModel

class HowtoFragment : Fragment(R.layout.fragment_howto) {

    private val viewModel by viewModels<HowtoViewModel>()

    private lateinit var howtoRecycler: RecyclerView
    private lateinit var howtoList: ArrayList<Howtos>
    private lateinit var HowtoAdapter: HowtoAdapter



    lateinit var howtoicon: Array<Int>
    lateinit var howtotitle: Array<String>
    lateinit var howtonum: Array<String>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        howtoList = arrayListOf<Howtos>()
        howtoicon = arrayOf(

            R.drawable.ic_baseline_payments_24,
            R.drawable.ic_baseline_account_balance_wallet_24,
            R.drawable.unlock,
            R.drawable.ic_baseline_payments_24,
            R.drawable.settings_icons,
            R.drawable.policies,
            R.drawable.warranty


        )
        howtotitle = arrayOf(
            getString(R.string.guide1_title),
            getString(R.string.guide2_title),
            getString(R.string.guide3_title),
            getString(R.string.guide4_title),
            getString(R.string.guide5_title),
            getString(R.string.guide7_title),
            getString(R.string.guide8_title)

        )

        howtonum = arrayOf(
                "1","2","3","4","5","7","8"

        )




        for (i in howtoicon.indices) {
            val howtos = Howtos(howtoicon[i], howtotitle[i])
            howtoList.add(howtos)

        }

        val layoutManager = LinearLayoutManager(context)
        howtoRecycler = view.findViewById(R.id.howto_recycler)
        howtoRecycler.layoutManager = layoutManager
        howtoRecycler.setHasFixedSize(true)
        HowtoAdapter = HowtoAdapter(howtoList)
        howtoRecycler.adapter = HowtoAdapter

        HowtoAdapter.setOnItemClickListener(object : HowtoAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                val action = HowtoFragmentDirections.actionNavHowtoToNavGuideview(position+1,howtotitle[position])
            findNavController().navigate(action)
            }

        })




    }
}