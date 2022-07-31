package com.example.mkopaapp.ui.howto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.Navigation.setViewNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mkopaapp.R
import com.example.mkopaapp.ui.products.Phones
import kotlin.coroutines.coroutineContext

class HowtoAdapter(private val howtosList:ArrayList<Howtos>) : RecyclerView.Adapter<HowtoAdapter.HowtosViewHolder>(){
    private lateinit var tutListener : onItemClickListener

    interface  onItemClickListener{

        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        tutListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HowtosViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.howto_item, parent,false)
        return HowtosViewHolder(itemView,tutListener)
    }

    override fun onBindViewHolder(holder: HowtosViewHolder, position: Int) {
        val current_howtos = howtosList[position]
        holder.howtosimageView.setImageResource(current_howtos.howtosicon)
        holder.howtosnameText.text = current_howtos.howtosName

    }

    override fun getItemCount(): Int {
        return howtosList.size

    }

    class HowtosViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val howtosimageView : ImageView = itemView.findViewById(R.id.guide_image)
        val howtosnameText : TextView = itemView.findViewById(R.id.guidename_text)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }




    }




}