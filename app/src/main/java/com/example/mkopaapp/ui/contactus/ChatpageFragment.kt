package com.example.mkopaapp.ui.contactus

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkopaapp.R
//import com.example.mkopaapp.ui.contactus.Constants.GUIDE10_BTN
import com.example.mkopaapp.ui.contactus.Constants.GUIDE15_BTN
import com.example.mkopaapp.ui.contactus.Constants.GUIDE1_BTN
import com.example.mkopaapp.ui.contactus.Constants.GUIDE2_BTN
import com.example.mkopaapp.ui.contactus.Constants.GUIDE3_BTN
import com.example.mkopaapp.ui.contactus.Constants.GUIDE5_BTN
import com.example.mkopaapp.ui.contactus.Constants.GUIDE6_BTN
import com.example.mkopaapp.ui.contactus.Constants.GUIDE7_BTN
import com.example.mkopaapp.ui.contactus.Constants.GUIDE8_BTN
import com.example.mkopaapp.ui.contactus.Constants.NULL_BTN
import com.example.mkopaapp.ui.contactus.Constants.RECEIVE_ID
import com.example.mkopaapp.ui.contactus.Constants.RECEIVE_ID_1BUTTONS
import com.example.mkopaapp.ui.contactus.Constants.RECEIVE_ID_2BUTTONS
import com.example.mkopaapp.ui.contactus.Constants.RECEIVE_ID_3BUTTONS
import com.example.mkopaapp.ui.contactus.Constants.SEND_ID
import kotlinx.coroutines.*

class ChatpageFragment : Fragment(R.layout.fragment_chatpage) {

    private val viewModel by viewModels<ContactusViewModel>()
    private lateinit var chatRecycler: RecyclerView
    private lateinit var chat_editmsg: EditText
    private lateinit var sendBtn: Button
//    private lateinit var chatlinks_btn1: Button
    private lateinit var adapter: ChatAdapter

    private val botList = listOf("Salma_Bot", "Kevin_Bot", "Grace_Bot", "James_Bot")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendBtn = view.findViewById(R.id.btn_send)
        chat_editmsg = view.findViewById(R.id.et_message)
        chatRecycler = view.findViewById(R.id.chat_recycler)
//        chatlinks_btn1 = view.findViewById(R.id.chatlinks_btn1)

        recyclerView()
        clickEvents()

        val random = (0..3).random()
        greetMessage("Hi! This is ${botList[random]}, how may i help")






    }

    private fun clickEvents(){
        sendBtn.setOnClickListener {
            sendMessage()
        }
        chat_editmsg.setOnClickListener {
            GlobalScope.launch {
                delay(1000)
                withContext(Dispatchers.Main){
                    chatRecycler.scrollToPosition(adapter.itemCount-1)
                }
            }
        }
//        chatlinks_btn1.setOnClickListener {
//            Toast.makeText(activity,"testing", Toast.LENGTH_SHORT).show()
//        }

    }

    private fun recyclerView(){
        adapter = ChatAdapter()
        chatRecycler.adapter = adapter
        chatRecycler.layoutManager = LinearLayoutManager(context)
    }

    private fun sendMessage(){

        val message = chat_editmsg.text.toString()
        val timeStamp = Time.timeStamp()

        if(message.isNotEmpty()){
            chat_editmsg.setText("")

            adapter.insertMessage(Chatmessages(message, SEND_ID, timeStamp, NULL_BTN,NULL_BTN,NULL_BTN))
            chatRecycler.scrollToPosition(adapter.itemCount-1)

            botResponse(message)
        }

    }

    private fun botResponse(message: String){

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
        //      Warranty -> 9
        //      Returns -> 10

        val timeStamp = Time.timeStamp()
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                val response = BotResponse.basicResponses(message)
                val nonbtns = listOf<String>("0","1","2","3","4")

                if (nonbtns.contains(response[1])){
                    adapter.insertMessage(Chatmessages(response[0], RECEIVE_ID, timeStamp, NULL_BTN,
                        NULL_BTN, NULL_BTN))
                    chatRecycler.scrollToPosition(adapter.itemCount-1)}

                if (response[1] === "5"){
                    adapter.insertMessage(Chatmessages(response[0], RECEIVE_ID_1BUTTONS, timeStamp, GUIDE5_BTN, NULL_BTN, NULL_BTN))
                    chatRecycler.scrollToPosition(adapter.itemCount-1)}
                if (response[1] === "6"){
                    adapter.insertMessage(Chatmessages(response[0], RECEIVE_ID_1BUTTONS, timeStamp, GUIDE6_BTN, NULL_BTN, NULL_BTN))
                    chatRecycler.scrollToPosition(adapter.itemCount-1)}
                if (response[1] === "7"){
                    adapter.insertMessage(Chatmessages(response[0], RECEIVE_ID_3BUTTONS, timeStamp,GUIDE1_BTN, GUIDE3_BTN, GUIDE15_BTN))
                    chatRecycler.scrollToPosition(adapter.itemCount-1)}
                if (response[1] === "8"){
                    adapter.insertMessage(Chatmessages(response[0], RECEIVE_ID_2BUTTONS, timeStamp, GUIDE2_BTN, NULL_BTN, NULL_BTN))
                    chatRecycler.scrollToPosition(adapter.itemCount-1)}
                if (response[1] === "9"){
                    adapter.insertMessage(Chatmessages(response[0], RECEIVE_ID_1BUTTONS, timeStamp, GUIDE7_BTN, NULL_BTN, NULL_BTN))
                    chatRecycler.scrollToPosition(adapter.itemCount-1)}
                if (response[1] === "10"){
                    adapter.insertMessage(Chatmessages(response[0], RECEIVE_ID_1BUTTONS, timeStamp, GUIDE8_BTN, NULL_BTN, NULL_BTN))
                    chatRecycler.scrollToPosition(adapter.itemCount-1)}


            }
        }
    }


    override fun onStart() {
        super.onStart()

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                chatRecycler.scrollToPosition(adapter.itemCount-1)
            }
        }
    }

    private fun greetMessage(message: String){
        val timeStamp = Time.timeStamp()
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                adapter.insertMessage(Chatmessages(message, RECEIVE_ID, timeStamp,NULL_BTN,NULL_BTN,NULL_BTN))
                chatRecycler.scrollToPosition(adapter.itemCount-1)
            }
        }

    }







}