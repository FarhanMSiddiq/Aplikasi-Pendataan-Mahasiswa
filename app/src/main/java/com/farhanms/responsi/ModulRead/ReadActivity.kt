package com.farhanms.responsi.ModulRead

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.farhanms.responsi.Data
import com.farhanms.responsi.ModulCreate.CreateActivity
import com.farhanms.responsi.R
import kotlinx.android.synthetic.main.activity_read.*

class ReadActivity : AppCompatActivity() {


    lateinit var mDatabase: DatabaseReference
    private var dataList = ArrayList<Data>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)


        mDatabase = FirebaseDatabase.getInstance().getReference("Data")
        rv_data.layoutManager = LinearLayoutManager(this)
        getData()

        create_data.setOnClickListener{
            val intent = Intent(this@ReadActivity, CreateActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                dataList.clear()
                for (getdataSnapshot in dataSnapshot.getChildren()) {

                    val Data = getdataSnapshot.getValue(Data::class.java!!)
                    dataList.add(Data!!)
                }

                rv_data.adapter = Adapter(dataList){
                    val intent = Intent(this@ReadActivity, DetailActivity::class.java).putExtra("data", it)
                    startActivity(intent)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ReadActivity, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}