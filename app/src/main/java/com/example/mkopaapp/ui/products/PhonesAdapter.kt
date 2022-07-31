package com.example.mkopaapp.ui.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mkopaapp.R
import com.example.mkopaapp.ui.howto.HowtoAdapter

class PhonesAdapter(private val phonesList:ArrayList<Phones>) : RecyclerView.Adapter<PhonesAdapter.PhonesViewHolder>(){
    private lateinit var phoneListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        phoneListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhonesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_phoneitem, parent,false)
        return PhonesViewHolder(itemView,phoneListener)
    }

    override fun onBindViewHolder(holder: PhonesViewHolder, position: Int) {
        val currentphone = phonesList[position]
        holder.phoneimageView.setImageResource(currentphone.phoneimage)
        holder.phonenameText.text = currentphone.phoneName
        holder.phonedetailsText.text = currentphone.phoneDetails
        holder.phonepriceText.text = currentphone.phonePrice
        holder.phoneinstallmentsText.text = currentphone.phoneInstallments

    }

    override fun getItemCount(): Int {
        return phonesList.size

    }

    class PhonesViewHolder(itemView: View,listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val phoneimageView : ImageView = itemView.findViewById(R.id.phone_image)
        val phonenameText : TextView = itemView.findViewById(R.id.phonename_text)
        val phonedetailsText : TextView = itemView.findViewById(R.id.phonedetails_text)
        val phonepriceText : TextView = itemView.findViewById(R.id.phoneprice_text)
        val phoneinstallmentsText : TextView = itemView.findViewById(R.id.phonepayments_text)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

    }




}
}