package com.example.mkopaapp.ui.products
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkopaapp.R
import com.example.mkopaapp.databinding.FragmentLangsBinding
import com.example.mkopaapp.databinding.FragmentProductsBinding
import com.example.mkopaapp.ui.howto.HowtoAdapter
import com.example.mkopaapp.ui.howto.HowtoFragmentDirections
import com.example.mkopaapp.ui.languages.LanguagesViewModel


class ProductsFragment : Fragment(R.layout.fragment_products) {

    private val viewModel by viewModels<ProductsViewModel>()
    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    private lateinit var phoneRecycler: RecyclerView
    private lateinit var phonesList: ArrayList<Phones>
    private lateinit var phonesAdapter: PhonesAdapter

    lateinit var imageId : Array<Int>
    lateinit var phoneName : Array<String>
    lateinit var phonePrice : Array<String>
    lateinit var phoneDetails : Array<String>
    lateinit var phoneInstallments : Array<String>





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        dataInitialize()
        phonesList = arrayListOf<Phones>()
        imageId = arrayOf(
            R.drawable.phone_1,
            R.drawable.phone_2,
            R.drawable.phone_3,
            R.drawable.phone_1,
            R.drawable.phone_2,
            R.drawable.phone_3
        )
        phoneName = arrayOf(
            getString(R.string.phone1_name),
            getString(R.string.phone2_name),
            getString(R.string.phone3_name),
            getString(R.string.phone1_name),
            getString(R.string.phone2_name),
            getString(R.string.phone3_name)
        )

        phoneDetails = arrayOf(
            getString(R.string.phone1_details_short),
            getString(R.string.phone2_details_short),
            getString(R.string.phone3_details_short),
            getString(R.string.phone1_details_short),
            getString(R.string.phone2_details_short),
            getString(R.string.phone3_details_short)
        )

        phonePrice = arrayOf(
            getString(R.string.phone1_price),
            getString(R.string.phone2_price),
            getString(R.string.phone3_price),
            getString(R.string.phone1_price),
            getString(R.string.phone2_price),
            getString(R.string.phone3_price)
        )

        phoneInstallments = arrayOf(
            getString(R.string.phone1_dailyinst),
            getString(R.string.phone2_dailyinst),
            getString(R.string.phone3_dailyinst),
            getString(R.string.phone1_dailyinst),
            getString(R.string.phone2_dailyinst),
            getString(R.string.phone3_dailyinst)
        )

        for (i in imageId.indices){
            val phones = Phones(imageId[i],phoneName[i],phoneDetails[i],phonePrice[i],phoneInstallments[i])
            phonesList.add(phones)
        }


        val layoutManager = LinearLayoutManager(context)
        phoneRecycler = view.findViewById(R.id.phone_recycler)
        phoneRecycler.layoutManager = layoutManager
        phoneRecycler.setHasFixedSize(true)
        phonesAdapter = PhonesAdapter(phonesList)
        phoneRecycler.adapter = phonesAdapter

        phonesAdapter.setOnItemClickListener(object : PhonesAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                val action = ProductsFragmentDirections.actionNavProductsToNavProdItemDetails(position,phoneName[position],phonePrice[position],phoneInstallments[position],imageId[position])
                findNavController().navigate(action)



            }
        })




    }







}