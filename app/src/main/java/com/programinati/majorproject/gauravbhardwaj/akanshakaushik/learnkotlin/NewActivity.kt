package com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.Adapter.CatogriesAdapter
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.Model.CatogriesModel
import com.programinati.majorproject.gauravbhardwaj.akanshakaushik.learnkotlin.databinding.ActivityNewBinding

class NewActivity : AppCompatActivity() {


    lateinit var binding : ActivityNewBinding
    lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        var list = arrayListOf<String>("Love","Sad","Romentic","Attitude")

        db = FirebaseFirestore.getInstance()
        db.collection("ShayariBee").addSnapshotListener { value, error ->
            val list = arrayListOf<CatogriesModel>()
            val data = value?.toObjects(CatogriesModel::class.java)
            list.addAll(data!!)
            binding.recatogrise.layoutManager  = LinearLayoutManager(this)
            binding.recatogrise.adapter = CatogriesAdapter(this,list)
        }

        binding.btnnewmenu.setOnClickListener{
//            asa
            if (binding.drawablebar.isDrawerOpen(Gravity.LEFT))
            {
                binding.drawablebar.closeDrawer(Gravity.LEFT)
            }
            else
            {
                binding.drawablebar.closeDrawer(Gravity.LEFT)
            }
        }

        binding.navigation.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.share->
                {
                    try {
                        val shareIntent = Intent(Intent.ACTION_SEND)
                        shareIntent.type = "text/plain"
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
                        var shareMessage = "\nLet me recommend you this application\n\n"
                        shareMessage =
                            """
                            ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
                            
                            
                            """.trimIndent()
                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                        startActivity(Intent.createChooser(shareIntent, "choose one"))
                    } catch (e: Exception) {
                        //e.toString();
                        }
                    true
                }
                R.id.rate->
                {
                    true
                }
                R.id.more->
                {
                    true
                } else-> { false }
            }
        }


//        override fun onBackPressed()
//        {
//            if (binding.drawablebar.isDrawerOpen(Gravity.LEFT))
//            {
//                binding.drawablebar.closeDrawer(Gravity.LEFT)
//            }
//            else
//            {
//                super.onBackPressed()
//            }
//        }

    }
}