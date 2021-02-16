package hr.aktivnosti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.MomcadAdapter
import hr.adapteri.TablicaTablicaAdapter
import hr.database.NKJaksicDatabase
import hr.database.TablicaTablica
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.activity_momcad.*
import kotlinx.android.synthetic.main.activity_tablica.*

class TablicaActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablica)
        setSupportActionBar(findViewById(R.id.toolbarTablica))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Tablica"

        recyclerViewTablica.addItemDecoration(DividerItemDecoration
            (recyclerViewTablica.context,DividerItemDecoration.VERTICAL))

        val database = Room.databaseBuilder(
            this, NKJaksicDatabase::class.java,"nk_jaksic_baza"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        database.tablicaDao().insertTablicaTablica(TablicaTablica(0,1,"NK Jakšić",22,56-23,49))
        database.tablicaDao().insertTablicaTablica(TablicaTablica(1,2,"NK Jakšić",22,46-29,39))
        database.tablicaDao().insertTablicaTablica(TablicaTablica(2,3,"NK Jakšić",22,36-13,29))
        database.tablicaDao().insertTablicaTablica(TablicaTablica(3,4,"NK Jakšić",22,16-3,19))

        //database.tablicaDao().deleteTablicaTablica()

        val sveTabliceUBazi = database.tablicaDao().getTablicaTablica()

        recyclerViewTablica.apply {
            layoutManager = LinearLayoutManager(this@TablicaActivity)
            adapter = TablicaTablicaAdapter(sveTabliceUBazi)
        }

    }
}