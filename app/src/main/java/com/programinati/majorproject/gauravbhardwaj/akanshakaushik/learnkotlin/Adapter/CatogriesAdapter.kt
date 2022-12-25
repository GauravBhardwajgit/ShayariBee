package com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.common.collect.ComparisonChain.start
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.MainActivity
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.MainActivity3
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.Model.CatogriesModel
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.StartActivity
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.databinding.ItemCatogriesBinding
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.NewActivity

val colourlist = arrayListOf<String>("#55efc4","#81ecec","#74b9ff","a29bfe","#ffeaa7")
class CatogriesAdapter(val context: NewActivity, val list: ArrayList<CatogriesModel>) : RecyclerView.Adapter<CatogriesAdapter.CatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            ItemCatogriesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {

        if (position%5==0)
        {
            holder.binding.crush.setBackgroundColor(Color.parseColor(colourlist[0]))
        }
        else if(position%5==1)
        {
            holder.binding.crush.setBackgroundColor(Color.parseColor(colourlist[1]))
        }
        else if(position%5==2)
        {
            holder.binding.crush.setBackgroundColor(Color.parseColor(colourlist[2]))
        }
        else if(position%5==3)
        {
            holder.binding.crush.setBackgroundColor(Color.parseColor(colourlist[3]))
        }
        else if(position%5==4)
        {
            holder.binding.crush.setBackgroundColor(Color.parseColor(colourlist[4]))
        }
        holder.binding.crush.text = list[position].Name.toString()

        holder.binding.root.setOnClickListener {
            val intent = Intent(context,MainActivity3::class.java)
            intent.putExtra("ID",list[position].ID)
            intent.putExtra("Name",list[position].Name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = list.size
    class CatViewHolder(val binding: ItemCatogriesBinding) : RecyclerView.ViewHolder(binding.root)
}