package com.example.mkopaapp.ui.home

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mkopaapp.R
import com.example.mkopaapp.databinding.FragmentHomeBinding
import com.example.mkopaapp.databinding.FragmentLangsBinding
import com.example.mkopaapp.ui.languages.LanguagesViewModel
import com.example.mkopaapp.ui.myAccount.MyaccountFragment


class HomeFragment : Fragment(R.layout.fragment_home) {


    private val viewModel by viewModels<HomeViewModel>()
    private var _binding: FragmentHomeBinding? = null

    private lateinit var accountpg: ImageButton
    private lateinit var paymentspg: ImageButton
    private lateinit var chatpg: ImageButton
    private lateinit var howtospg: ImageButton
    private lateinit var offerspg: ImageButton
    private lateinit var storespg: ImageButton



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accountpg = view.findViewById(R.id.home_account)
        paymentspg = view.findViewById(R.id.home_pay)
        chatpg = view.findViewById(R.id.home_chat)
        howtospg = view.findViewById(R.id.home_howto)
        offerspg = view.findViewById(R.id.home_products)
        storespg = view.findViewById(R.id.home_servicecentres)



        accountpg.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_nav_account)
            requireActivity().run {
                Toast.makeText(this, "My Account", Toast.LENGTH_SHORT).show()
            }
        }

        paymentspg.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_nav_pay)
            requireActivity().run {
                Toast.makeText(this, "Make a Payment", Toast.LENGTH_SHORT).show()
            }
        }

        chatpg.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_nav_contact)
            requireActivity().run {

                Toast.makeText(this, "Chat with Us", Toast.LENGTH_SHORT).show()
            }

        }
        howtospg.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_nav_howto)
            requireActivity().run {
                Toast.makeText(this, "How-to Guides", Toast.LENGTH_SHORT).show()
            }
        }

        offerspg.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_nav_products)
            requireActivity().run {
                Toast.makeText(this, "Offers", Toast.LENGTH_SHORT).show()
            }
        }

        storespg.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_nav_servcenters)
            requireActivity().run {

                Toast.makeText(this, "Service Locations", Toast.LENGTH_SHORT).show()
            }

        }
    }


//    private var _binding: FragmentHomeBinding? = null
//
//    // This property is only valid between onCreateView and
//    // onDestroyView.
//    private val binding get() = _binding!!
//
//
//
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)
//
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        binding.homeAccount.setOnClickListener {
//            requireActivity().run {
//                Toast.makeText(this, "My Account Button", Toast.LENGTH_SHORT).show()
//
//            }
//        }
//        binding.homePay.setOnClickListener {
//            requireActivity().run {
//                Toast.makeText(this, "Make Payment", Toast.LENGTH_SHORT).show()
//
//            }
//        }
//        binding.homeChat.setOnClickListener {
//            requireActivity().run {
//                Toast.makeText(this, "Chat with Us", Toast.LENGTH_SHORT).show()
//            }
//        }
//        binding.homeHowto.setOnClickListener {
//            requireActivity().run {
//                Toast.makeText(this, "Make Payment", Toast.LENGTH_SHORT).show()
//
//            }
//        }
//        binding.homeProducts.setOnClickListener {
//            requireActivity().run {
//                Toast.makeText(this, "Special Offers", Toast.LENGTH_SHORT).show()
//            }
//        }
//        binding.homeServicecentres.setOnClickListener {
//            requireActivity().run {
//                Toast.makeText(this, "Service Centers", Toast.LENGTH_SHORT).show()
//
//            }
//        }
//
//
//
//
//
//
//
//        return root
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}