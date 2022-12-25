package com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.Adapter.AlllistAdapter
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.Model.Alllist
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding
    lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("Name")
        val ID  = intent.getStringExtra("ID")

        db  = FirebaseFirestore.getInstance()

        db.collection("ShayariBee").document(ID!!).collection("All").addSnapshotListener { value, error ->
            val shayarilist = arrayListOf<Alllist>()
            val date = value?.toObjects(Alllist::class.java)
            shayarilist.addAll(date!!)
            binding.rcvallshayari.layoutManager = LinearLayoutManager(this)
            binding.rcvallshayari.adapter = AlllistAdapter(this,shayarilist)
        }

        binding.btnbackcatnew.setOnClickListener{
             onBackPressed()
        }
        binding.Catname.text = name.toString()

    }
}