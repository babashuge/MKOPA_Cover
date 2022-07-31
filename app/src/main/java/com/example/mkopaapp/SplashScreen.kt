package com.example.mkopaapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity



class SplashScreen: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)


//        lateinit var splash_logo: ImageView
//        lateinit var power_logo: ImageView
//        lateinit var to_logo: ImageView
//        lateinit var own_logo: ImageView

        val splash_logo = R.id.splash_logo




        val logo_anim1 = AnimationUtils.loadAnimation(this,R.anim.logo_top_anim)
        val logo_anim2 = AnimationUtils.loadAnimation(this,R.anim.logo_bottom1_anim)
        val logo_anim3 = AnimationUtils.loadAnimation(this,R.anim.logo_bottom2_anim)
        val logo_anim4 = AnimationUtils.loadAnimation(this,R.anim.logo_bottom3_anim)


//        splash_logo.startAnimation(logo_anim1)
//        power_logo.startAnimation(logo_anim2)
//        to_logo.startAnimation(logo_anim3)
//        own_logo.startAnimation(logo_anim4)

        val splashScreenTimeout = 4000
        val homeIntent = Intent (this@SplashScreen, MainActivity::class.java)

        Handler().postDelayed({
                startActivity(homeIntent)
                finish()
            }, splashScreenTimeout.toLong())








    }
}