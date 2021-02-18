package hr.aktivnosti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.MomcadAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.Igraci
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.activity_momcad.*

class MomcadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_momcad)
        setSupportActionBar(findViewById(R.id.toolbarMomcad))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Momcad"

        recyclerviewMomcad.addItemDecoration(DividerItemDecoration
            (recyclerviewMomcad.context,DividerItemDecoration.VERTICAL))

        val database = Room.databaseBuilder(
            this,NKJaksicDatabase::class.java,"nk_jaksic_baza"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

/*
        database.igraciDao().insertIgrac(Igraci(0,"Domagoj","Kovačević",5))
        database.igraciDao().insertIgrac(Igraci(1,"Matko","Kovačević",1))
        database.igraciDao().insertIgrac(Igraci(2,"Maurizio","Rezo",10))
        database.igraciDao().insertIgrac(Igraci(3,"Stjepan","Šilhan",8))
        database.igraciDao().insertIgrac(Igraci(4,"Ivan","Brus",11))
        database.igraciDao().insertIgrac(Igraci(5,"Ivan","Franjić",40))
        database.igraciDao().insertIgrac(Igraci(6,"Petar","Jurić",45))
        database.igraciDao().insertIgrac(Igraci(7,"Josip","Raguž",94))
        database.igraciDao().insertIgrac(Igraci(8,"Mateo","Palameta",6))
        database.igraciDao().insertIgrac(Igraci(9,"Lukas","Begić",2))
        database.igraciDao().insertIgrac(Igraci(10,"Dino","Banušić",6))
        database.igraciDao().insertIgrac(Igraci(11,"Jakov","Barišić",86))
        database.igraciDao().insertIgrac(Igraci(12,"Denis","Ružman",20))
*/
        //database.igraciDao().deletePodatke()
        val sviIgraciUBazi = database.igraciDao().getIgraciData()

        recyclerviewMomcad.apply {
            layoutManager = LinearLayoutManager(this@MomcadActivity)
            adapter = MomcadAdapter(sviIgraciUBazi)
        }
    }
}