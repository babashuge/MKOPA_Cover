package com.example.mkopaapp.ui.contactus

import com.example.mkopaapp.databinding.HowtoItemBinding
import com.example.mkopaapp.ui.contactus.Constants.OPEN_HOWTOS
import com.example.mkopaapp.ui.contactus.Constants.OPEN_PRODUCTS

object BotResponse {
    fun basicResponses(_message: String) : List<String>{

        val random = (0..2).random()
        val message = _message.toLowerCase()
        lateinit var messagereply : List<String>

        val hiResponse = "Hey there!, how can i help you today"
        val thanksResponse = "You are welcome, I am glad to be of assistance. Feel free to ask me anything, " +
                "anytime you need help"
        val howRuResponse = "Im doing alright, thanks for asking!"
        val errorResponse = "Sorry, i did not understand. Try asking the question in a different way"
        val helpResponse = "Tell me more... What do you need assistance on?"
        val paymentsResponse = "To learn how to make a payment or to unlock a device, " +
                "kindly choose one of the options below"
        val internetResponse = "Oh. Internet issues? ... Kindly choose one of the options below to learn how to, or solve issues with internet and data"
        val storeResponse = "Click the link below to find the nearest point of service"




        when{

            //BotResponse Codes
                //      Hi/Hello -> 0
                //      Thanks -> 1
                //      How are you -> 2
                //      Help -> 3
                //      Error -> 4
                //      Internet/Data -> 5
                //      Stores -> 6
                //      Pay/Unlock -> 7
                //      Account -> 8



            //Hello or Hi
            message.contains("hello") or message.contains("hi")
             ->messagereply = (listOf(hiResponse,"0"))



            //Thanks
            message.contains("thank") or message.contains("thanks")->
                messagereply = (listOf(thanksResponse,"1"))



            //Internet/Data
            message.contains("internet") or message.contains("data")
                -> messagereply = (listOf(internetResponse,"5"))

            //Stores
            message.contains("shop") or message.contains("agent") or message.contains("duka")or message.contains("store")
                -> messagereply = (listOf(storeResponse,"6"))


            //Payments/Unlocking
            message.contains("payment") or message.contains("pay") or message.contains("unlock")
                    or message.contains("locked")->
                messagereply = (listOf(paymentsResponse,"7"))


            //Help
            message.contains("help") or message.contains("assistance")->
                messagereply = (listOf(helpResponse,"3"))



            //How are you
            message.contains("how are you") ->
                messagereply = (listOf(howRuResponse,"2"))

            //Accounts
            message.contains("balance") or message.contains("account") or message.contains("profile")
            -> messagereply = (listOf(storeResponse,"8"))


            else -> messagereply = (listOf(errorResponse,"4"))
        }

        return messagereply
    }


}

