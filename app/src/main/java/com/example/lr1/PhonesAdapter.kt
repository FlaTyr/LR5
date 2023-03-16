package com.example.lr1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhonesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mPhoneList: ArrayList<PhoneModel> = ArrayList()

    fun setupPhones(phonesList: ArrayList<PhoneModel>){
        mPhoneList.clear()
        mPhoneList.addAll(phonesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.recyclerview_item, parent, false)
        return PhonesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PhonesViewHolder){
            holder.bind(mPhones = mPhoneList[position])
        }
    }

    override fun getItemCount(): Int {
        return mPhoneList.count()
    }

    class PhonesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val nameTV = itemView.findViewById<TextView>(R.id.name)
        val priceTV = itemView.findViewById<TextView>(R.id.launchPriceVal)
        val dateTV = itemView.findViewById<TextView>(R.id.launchDateVal)
        val camTV = itemView.findViewById<TextView>(R.id.camVal)

        fun bind(mPhones: PhoneModel){
            nameTV.text = mPhones.name
            priceTV.text = mPhones.price
            dateTV.text = mPhones.date
            camTV.text = mPhones.score
        }


    }

}

