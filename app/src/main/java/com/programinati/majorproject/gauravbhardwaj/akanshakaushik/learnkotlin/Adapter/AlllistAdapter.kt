package com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.Adapter

import android.content.ActivityNotFoundException
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.*
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.Model.Alllist
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.databinding.TemshayariBinding


class AlllistAdapter(val context: MainActivity3,val shayarilist: ArrayList<Alllist>) : RecyclerView.Adapter<AlllistAdapter.AllViewHolder>() {


    class AllViewHolder(val binding: TemshayariBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllViewHolder {
        return AllViewHolder(TemshayariBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: AllViewHolder, position: Int) {



        if (position%5==0)
        {
            holder.binding.grabackplace.setBackgroundResource(R.drawable.gradient1)
        }
        else if(position%5==1)
        {
            holder.binding.grabackplace.setBackgroundResource(R.drawable.gradient2)
        }
        else if(position%5==2)
        {
            holder.binding.grabackplace.setBackgroundResource(R.drawable.gradient3)
        }
        else if(position%5==3)
        {
            holder.binding.grabackplace.setBackgroundResource(R.drawable.gradient4)
        }
        else if(position%5==4)
        {
            holder.binding.grabackplace.setBackgroundResource(R.drawable.gradient4)
        }
        holder.binding.shayrione.text=shayarilist[position].Data.toString()

        holder.binding.sharebtn.setOnClickListener {

            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plan"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,"ShayariBee")
                var shareMessage = "\n ${shayarilist[position].Data}"
                shareMessage="""
                    ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
                """.trimIndent()
                shareIntent.putExtra(Intent.EXTRA_TEXT,shareMessage)
                context.startActivity(Intent.createChooser(shareIntent,"choose one"))
                Toast.makeText(context,"Share App Successfully done",Toast.LENGTH_LONG).show()
            }
            catch(e : Exception) {
//
            }
        }
        holder.binding.copybut.setOnClickListener {
            val clipboard: ClipboardManager? =
                context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?
            val clip = ClipData.newPlainText("label", shayarilist[position].Data.toString())
            clipboard?.setPrimaryClip(clip)

            Toast.makeText(context,"shayari coppied Successfully ",Toast.LENGTH_LONG).show()
        }
        holder.binding.whatsappbtn.setOnClickListener {
            val whatsappIntent = Intent(Intent.ACTION_SEND)
            whatsappIntent.type = "text/plain"
            whatsappIntent.setPackage("com.whatsapp")
            whatsappIntent.putExtra(Intent.EXTRA_TEXT, shayarilist[position].Data.toString())
            try {
                context.startActivity(whatsappIntent)
                Toast.makeText(context,"Share App Successfully done",Toast.LENGTH_LONG).show()

            } catch (ex: ActivityNotFoundException) {
            }
        }
    }

    override fun getItemCount()=shayarilist.size
}