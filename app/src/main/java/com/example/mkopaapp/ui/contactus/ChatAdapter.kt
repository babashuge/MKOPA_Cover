package com.example.mkopaapp.ui.contactus

import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mkopaapp.R
import com.example.mkopaapp.ui.contactus.Constants.SEND_ID
import com.example.mkopaapp.ui.contactus.Chatmessages
import com.example.mkopaapp.ui.contactus.Constants.RECEIVE_ID
import com.example.mkopaapp.ui.contactus.Constants.RECEIVE_ID_1BUTTONS
import com.example.mkopaapp.ui.contactus.Constants.RECEIVE_ID_2BUTTONS
import com.example.mkopaapp.ui.contactus.Constants.RECEIVE_ID_3BUTTONS
import kotlin.coroutines.coroutineContext


class ChatAdapter : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>(){
    var chatsList = mutableListOf<Chatmessages>()
    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                chatsList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }

    }


    private lateinit var navListener : onItemClickListener

    interface  onItemClickListener{

        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        navListener = listener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.chatmsg_item,parent,false))
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val currentMessage = chatsList[position]
        val btntitles =  listOf<String>(
            "Blank",
            "How to make a payment through the M-KOPA app",
            "How to check your M-KOPA balance",
            "How to unlock your NOKIA device",
            "How to make a payment through M-PESA",
            "How to turn on internet on your device",
            "Show nearest shop/agent",
            "Show M-KOPA Warranty Policy",
            "Show M-KOPA Return Policy",
            "How to enjoy M-KOPA services, bila hustle"
            )
        val btn1_nav_toguide = ChatpageFragmentDirections.actionNavChatpageToNavGuideview(currentMessage.replybtn1,btntitles[currentMessage.replybtn1])
        val btn2_nav_toguide = ChatpageFragmentDirections.actionNavChatpageToNavGuideview(currentMessage.replybtn2,btntitles[currentMessage.replybtn2])
        val btn3_nav_toguide = ChatpageFragmentDirections.actionNavChatpageToNavGuideview(currentMessage.replybtn3,btntitles[currentMessage.replybtn3])
        val btn1_nav_tostores = ChatpageFragmentDirections.actionNavChatpageToNavServcenters()

        when (currentMessage.chatid){
            SEND_ID -> {
                holder.itemView.findViewById<TextView>(R.id.tv_clientmsg).apply{
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.findViewById<TextView>(R.id.tv_botmsg).visibility = View.GONE
                holder.itemView.findViewById<TextView>(R.id.chatlinks_btn1).visibility = View.GONE
                holder.itemView.findViewById<TextView>(R.id.chatlinks_btn2).visibility = View.GONE
                holder.itemView.findViewById<TextView>(R.id.chatlinks_btn3).visibility = View.GONE
            }

            RECEIVE_ID -> {
                holder.itemView.findViewById<TextView>(R.id.tv_botmsg).apply{
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.findViewById<TextView>(R.id.tv_clientmsg).visibility = View.GONE
                holder.itemView.findViewById<TextView>(R.id.chatlinks_btn1).visibility = View.GONE
                holder.itemView.findViewById<TextView>(R.id.chatlinks_btn2).visibility = View.GONE
                holder.itemView.findViewById<TextView>(R.id.chatlinks_btn3).visibility = View.GONE
            }


//    REF     GUIDE1_BTN = "How to make a payment through the M-KOPA app"
//            GUIDE2_BTN = "How to check your M-KOPA balance"
//            GUIDE3_BTN = "How to unlock your NOKIA device"
//            GUIDE4_BTN = "How to make a payment through M-PESA"
//            GUIDE5_BTN = "How to turn on internet on your device"
//            GUIDE6_BTN = "Show nearest shop/agent"
//            GUIDE7_BTN = "Show M-KOPA Warranty Policy"
//            GUIDE8_BTN = "R.string.guide8_title"
//            GUIDE15_BTN = "How to enjoy M-KOPA services, bila hustle"

            RECEIVE_ID_1BUTTONS -> {
                holder.itemView.findViewById<TextView>(R.id.tv_botmsg).apply{
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.findViewById<Button>(R.id.chatlinks_btn1).apply{
                    text = btntitles[currentMessage.replybtn1]
                    visibility = View.VISIBLE
                    setOnClickListener {
                        if (currentMessage.replybtn1 == 6){
                            findNavController().navigate(btn1_nav_tostores)
                        }
                        else
                            findNavController().navigate(btn1_nav_toguide)
                    }

                }
                holder.itemView.findViewById<TextView>(R.id.tv_clientmsg).visibility = View.GONE
                holder.itemView.findViewById<TextView>(R.id.chatlinks_btn1).visibility = View.VISIBLE
                holder.itemView.findViewById<TextView>(R.id.chatlinks_btn2).visibility = View.GONE
                holder.itemView.findViewById<TextView>(R.id.chatlinks_btn3).visibility = View.GONE
            }
            RECEIVE_ID_2BUTTONS -> {
                holder.itemView.findViewById<TextView>(R.id.tv_botmsg).apply{
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.findViewById<Button>(R.id.chatlinks_btn1).apply{
                    text = btntitles[currentMessage.replybtn1]
                    visibility = View.VISIBLE
                    setOnClickListener {
                        if (currentMessage.replybtn1 == 6){
                            findNavController().navigate(btn1_nav_tostores)
                        }
                        else
                            findNavController().navigate(btn1_nav_toguide)
                    }

                }
                holder.itemView.findViewById<Button>(R.id.chatlinks_btn2).apply{
                    text = btntitles[currentMessage.replybtn2]
                    visibility = View.VISIBLE
                    setOnClickListener {
                        findNavController().navigate(btn2_nav_toguide)
                    }

                }

                holder.itemView.findViewById<TextView>(R.id.tv_clientmsg).visibility = View.GONE
                holder.itemView.findViewById<TextView>(R.id.chatlinks_btn1).visibility = View.VISIBLE
                holder.itemView.findViewById<TextView>(R.id.chatlinks_btn2).visibility = View.VISIBLE
                holder.itemView.findViewById<TextView>(R.id.chatlinks_btn3).visibility = View.GONE

            }

            RECEIVE_ID_3BUTTONS -> {
                holder.itemView.findViewById<TextView>(R.id.tv_botmsg).apply{
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.findViewById<Button>(R.id.chatlinks_btn1).apply{
                    text = btntitles[currentMessage.replybtn1]
                    visibility = View.VISIBLE
                    setOnClickListener {
                        if (currentMessage.replybtn1 == 6){
                            findNavController().navigate(btn1_nav_tostores)
                        }
                        else
                            findNavController().navigate(btn1_nav_toguide)
                    }

                }
                holder.itemView.findViewById<Button>(R.id.chatlinks_btn2).apply{
                    text = btntitles[currentMessage.replybtn2]
                    visibility = View.VISIBLE
                    setOnClickListener {
                           findNavController().navigate(btn2_nav_toguide)
                    }

                }
                holder.itemView.findViewById<Button>(R.id.chatlinks_btn3).apply {
                    text = btntitles[currentMessage.replybtn3]
                    visibility = View.VISIBLE
                    setOnClickListener {
                        findNavController().navigate(btn3_nav_toguide)
                    }
                }

                holder.itemView.findViewById<TextView>(R.id.tv_clientmsg).visibility = View.GONE
                holder.itemView.findViewById<TextView>(R.id.chatlinks_btn1).visibility = View.VISIBLE
                holder.itemView.findViewById<TextView>(R.id.chatlinks_btn2).visibility = View.VISIBLE
                holder.itemView.findViewById<TextView>(R.id.chatlinks_btn3).visibility = View.VISIBLE
            }


        }
    }


    override fun getItemCount(): Int {
        return chatsList.size
    }

    fun insertMessage(chatmessages: Chatmessages){
        this.chatsList.add(chatmessages)
        notifyItemInserted(chatsList.size)

    }







}
