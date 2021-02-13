package hr.aktivnosti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.MomcadAdapter
import hr.database.Igraci
import hr.database.NKJaksicDatabase
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.activity_momcad.*

class MomcadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_momcad)
        setSupportActionBar(findViewById(R.id.toolbarMomcad))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Momcad"

        val database = Room.databaseBuilder(
            this,NKJaksicDatabase::class.java,"nk_jaksic_baza"
        )
            .allowMainThreadQueries()
            .build()

        //database.igraciDao().delete(Igraci(0,"Domagoj","Kovačević",5))
        database.igraciDao().insertIgrac(Igraci(9,"Domagoj","Kovačević",5))
        database.igraciDao().insertIgrac(Igraci(10,"Matko","Kovačević",12))
        val sviIgraciUBazi = database.igraciDao().getIgraciData()

        recyclerviewMomcad.apply {
            layoutManager = LinearLayoutManager(this@MomcadActivity)
            adapter = MomcadAdapter(sviIgraciUBazi)
        }
    }
}