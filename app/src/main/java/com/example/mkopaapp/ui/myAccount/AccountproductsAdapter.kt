package com.example.mkopaapp.ui.myAccount

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mkopaapp.R
import com.example.mkopaapp.ui.products.Phones
import com.example.mkopaapp.ui.products.PhonesAdapter

class AccountproductsAdapter(private val accountproductList:ArrayList<Accountproducts>) : RecyclerView.Adapter<AccountproductsAdapter.AccountproductViewHolder>() {
    private lateinit var accountproductListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener) {
        accountproductListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountproductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_accountitem, parent, false)
        return AccountproductViewHolder(itemView,accountproductListener)
    }

    override fun onBindViewHolder(holder: AccountproductViewHolder, position: Int) {
        val current_accountproduct = accountproductList[position]
        holder.accountproductimageView.setImageResource(current_accountproduct.productimage)
        holder.accountproductnameText.text = current_accountproduct.productName
        holder.accountproductstatusText.text = current_accountproduct.productStatus
        holder.accountproductbalanceText.text = current_accountproduct.productBalance
        holder.accountproductnextpayText.text = current_accountproduct.productNextpay
        holder.accountproductprogress.progress = current_accountproduct.productProgress


    }

    override fun getItemCount(): Int {
        return accountproductList.size

    }

    class AccountproductViewHolder(itemView: View, listener: AccountproductsAdapter.onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val accountproductimageView: ImageView = itemView.findViewById(R.id.product_image)
        val accountproductnameText: TextView = itemView.findViewById(R.id.productname_text)
        val accountproductstatusText: TextView = itemView.findViewById(R.id.productstatus_text)
        val accountproductnextpayText: TextView = itemView.findViewById(R.id.product_nextpayin_text)
        val accountproductbalanceText: TextView = itemView.findViewById(R.id.productbal_text)
        val accountproductprogress: ProgressBar = itemView.findViewById(R.id.accountproduct_progressBar)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }


    }
}