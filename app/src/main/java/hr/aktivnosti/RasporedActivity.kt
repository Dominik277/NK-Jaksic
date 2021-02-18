package hr.aktivnosti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.RasporedAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.Raspored
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.activity_raspored.*

class RasporedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raspored)
        setSupportActionBar(findViewById(R.id.toolbarRaspored))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title="Raspored"

        recyclerviewRaspored.addItemDecoration(DividerItemDecoration
            (recyclerviewRaspored.context,DividerItemDecoration.VERTICAL))

        val database = Room.databaseBuilder(
            this, NKJaksicDatabase::class.java,"nk_jaksic_baza"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

/*
        database.rasporedDao().insertRaspored(Raspored(0,"24.02","NK Jakšić-NK Kuzmica"))
        database.rasporedDao().insertRaspored(Raspored(1,"28.02","NK Jakšić-NK Požega"))
        database.rasporedDao().insertRaspored(Raspored(2,"02.03","NK Jakšić-NK Vidovci"))
        database.rasporedDao().insertRaspored(Raspored(3,"14.03","NK Jakšić-NK Trenkovo"))
        database.rasporedDao().insertRaspored(Raspored(4,"24.03","NK Jakšić-NK Mihaljevci"))
*/
        //database.rasporedDao().deletePodatkeRaspored()
        val sviRasporediUBaziPodataka = database.rasporedDao().getRasporedData()

        recyclerviewRaspored.apply {
            layoutManager = LinearLayoutManager(this@RasporedActivity)
            adapter = RasporedAdapter(sviRasporediUBaziPodataka)
        }

    }
}