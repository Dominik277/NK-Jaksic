package hr.aktivnosti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.MomcadAdapter
import hr.adapteri.NajboljiStrijelciAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.NajboljiStrijelci
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.activity_momcad.*
import kotlinx.android.synthetic.main.activity_najbolji_strijelci.*

class NajboljiStrijelciActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_najbolji_strijelci)
        setSupportActionBar(findViewById(R.id.toolbarNajboljiStrijelci))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Najbolji strijelci"

        recyclerViewNajboljiStrijelci.addItemDecoration(DividerItemDecoration
            (recyclerViewNajboljiStrijelci.context,DividerItemDecoration.VERTICAL))

        val database = Room.databaseBuilder(
            this, NKJaksicDatabase::class.java,"nk_jaksic_baza"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        database.strijelciDao().insertNajboljiStrijelac(NajboljiStrijelci(0,1,"Domagoj Kovačević","27"))
        database.strijelciDao().insertNajboljiStrijelac(NajboljiStrijelci(1,2,"Matko Kovačević","25"))
        database.strijelciDao().insertNajboljiStrijelac(NajboljiStrijelci(2,3,"Tomislav Žuljević","22"))
        database.strijelciDao().insertNajboljiStrijelac(NajboljiStrijelci(3,4,"Luka Šporčić","19"))
        database.strijelciDao().insertNajboljiStrijelac(NajboljiStrijelci(4,5,"Stjepan Šilhan","17"))
        database.strijelciDao().insertNajboljiStrijelac(NajboljiStrijelci(5,6,"Ivan Brus","13"))

        //database.strijelciDao().deleteNajboljiStrijelci()
        val sviStrijelciUBazi = database.strijelciDao().getNajboljiStrijelciData()


        recyclerViewNajboljiStrijelci.apply {
            layoutManager = LinearLayoutManager(this@NajboljiStrijelciActivity)
            adapter = NajboljiStrijelciAdapter(sviStrijelciUBazi)
        }

    }
}