package com.example.mkopaapp.ui.payments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mkopaapp.R

class PaymentsproductsAdapter(private val paymentsproductList:ArrayList<Paymentsproducts>) : RecyclerView.Adapter<PaymentsproductsAdapter.PaymentsproductViewHolder>() {
    private lateinit var paymentsproductListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener) {
        paymentsproductListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentsproductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_accountitem, parent, false)
        return PaymentsproductViewHolder(itemView,paymentsproductListener)
    }

    override fun onBindViewHolder(holder: PaymentsproductViewHolder, position: Int) {
        val current_paymentsproduct = paymentsproductList[position]
        holder.paymentsproductimageView.setImageResource(current_paymentsproduct.productimage)
        holder.paymentsproductnameText.text = current_paymentsproduct.productName
        holder.paymentsproductstatusText.text = current_paymentsproduct.productStatus
        holder.paymentsproductbalanceText.text = current_paymentsproduct.productBalance
        holder.paymentsproductnextpayText.text = current_paymentsproduct.productNextpay
        holder.paymentsproductprogress.progress = current_paymentsproduct.productProgress


    }

    override fun getItemCount(): Int {
        return paymentsproductList.size

    }

    class PaymentsproductViewHolder(itemView: View, listener: PaymentsproductsAdapter.onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val paymentsproductimageView: ImageView = itemView.findViewById(R.id.product_image)
        val paymentsproductnameText: TextView = itemView.findViewById(R.id.productname_text)
        val paymentsproductstatusText: TextView = itemView.findViewById(R.id.productstatus_text)
        val paymentsproductnextpayText: TextView = itemView.findViewById(R.id.product_nextpayin_text)
        val paymentsproductbalanceText: TextView = itemView.findViewById(R.id.productbal_text)
        val paymentsproductprogress: ProgressBar = itemView.findViewById(R.id.accountproduct_progressBar)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }


    }
}