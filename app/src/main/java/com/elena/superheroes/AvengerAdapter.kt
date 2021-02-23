package com.elena.superheroes


import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elena.superheroes.databinding.ActivityProfileBinding

class AvengerAdapter: RecyclerView.Adapter<AvengerAdapter.AvengerViewHolder>() {

    private var avengerList =  listOf<Avenger>()

    class AvengerViewHolder(val itemBinding: ActivityProfileBinding) : RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvengerViewHolder{
        val itemBinding = ActivityProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AvengerViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: AvengerViewHolder, position: Int) {
        val avenger = avengerList[position]
        holder.itemBinding.ivPhoto.setImageResource(avenger.image)
        holder.itemBinding.tvName.text = avenger.nombre
    }

    override fun getItemCount(): Int {
        return avengerList.size
    }

    fun updateData(avengerList: List<Avenger>){
        this.avengerList = avengerList
        notifyDataSetChanged()
    }
}
