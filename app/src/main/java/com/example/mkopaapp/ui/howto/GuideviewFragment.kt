package com.example.mkopaapp.ui.howto

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.mkopaapp.R

class GuideviewFragment : Fragment(R.layout.fragment_guideview) {

//    private val viewModel by viewModels<HowtoViewModel>()

    private lateinit var guideView: ImageView

    val args: GuideviewFragmentArgs by navArgs()


    lateinit var guideimage: Array<Int>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Toast.makeText(activity,args.argGuideToast,Toast.LENGTH_SHORT).show()
        guideView = view.findViewById(R.id.guide_view)
        guideimage = arrayOf(
            0,
            R.drawable.how_to_pay_through_app,
            R.drawable.balance_check_full,
            R.drawable.how_to_pay_locked_nokia_full,
            R.drawable.how_to_pay_mpesa,
            R.drawable.how_to_internet,
            6,
            R.drawable.howto_warranty,
            R.drawable.howto_returns,
            R.drawable.how_to_internet
        )

        guideView.setImageResource(guideimage[args.argGuideView])

        }


    }




