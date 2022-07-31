package com.example.mkopaapp.ui.contactus

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mkopaapp.R
import com.example.mkopaapp.databinding.FragmentContactusBinding
import com.example.mkopaapp.ui.languages.LanguagesViewModel

class ContactusFragment : Fragment(R.layout.fragment_contactus) {

    private val viewModel by viewModels<ContactusViewModel>()

    private lateinit var chatNow: CardView
    private lateinit var chatWhatsapp: CardView
    private lateinit var chatCall: CardView
    private lateinit var chatMail: CardView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chatNow = view.findViewById(R.id.button_chatnow)
        chatWhatsapp = view.findViewById(R.id.button_chatwhatsapp)
        chatCall = view.findViewById(R.id.button_chatphone)
        chatMail = view.findViewById(R.id.button_chatemail)


        chatNow.setOnClickListener {
            findNavController().navigate(R.id.action_nav_contact_to_nav_chatpage)
        }

        chatWhatsapp.setOnClickListener {
            requireActivity().run {
                Toast.makeText(this, "Opens Whatsapp chat", Toast.LENGTH_SHORT).show()
            }
        }

        chatCall.setOnClickListener {
            val callintent = Intent(Intent.ACTION_DIAL)
            callintent.data = Uri.parse("tel:" + getString(R.string.contacts_phonenum))

            startActivity(callintent)
        }

        chatMail.setOnClickListener {
            val emailintent = Intent(Intent.ACTION_SENDTO).apply {

                data = Uri.parse("mailto:" + getString(R.string.contacts_email))
                putExtra(Intent.EXTRA_SUBJECT,getString(R.string.contacts_emailsubject))


            }
            val pkgmgr = view.context.packageManager
            if (emailintent.resolveActivity(pkgmgr) !=null){
                startActivity(emailintent)
            }
            else
                requireActivity().run {
                    Toast.makeText(this, "Please install an email application", Toast.LENGTH_SHORT).show()
                }



        }






    }
}