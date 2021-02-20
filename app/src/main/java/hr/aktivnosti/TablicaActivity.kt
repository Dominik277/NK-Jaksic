package hr.aktivnosti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.TablicaTablicaAdapter
import hr.database.NKJaksicDatabase
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.activity_tablica.*

class TablicaActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablica)
        setSupportActionBar(findViewById(R.id.toolbarTablica))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Tablica"

        gumbNajboljiStrijelci.setOnClickListener {
            val intent = Intent(this, NajboljiStrijelciActivity::class.java)
            startActivity(intent)
        }

        recyclerViewTablica.addItemDecoration(DividerItemDecoration
            (recyclerViewTablica.context,DividerItemDecoration.VERTICAL))
        recyclerViewTablica.addItemDecoration(DividerItemDecoration
            (recyclerViewTablica.context,DividerItemDecoration.HORIZONTAL))

        val database = Room.databaseBuilder(
            this, NKJaksicDatabase::class.java,"nk_jaksic_baza"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        /*

        database.tablicaDao().insertTablicaTablica(TablicaTablica(0,1,"NK Jakšić",22,56-23,49))
        database.tablicaDao().insertTablicaTablica(TablicaTablica(1,2,"NK Požega",22,46-29,39))
        database.tablicaDao().insertTablicaTablica(TablicaTablica(2,3,"NK Lipik",22,36-13,29))
        database.tablicaDao().insertTablicaTablica(TablicaTablica(3,4,"NK Pakrac",22,16-3,19))
        database.tablicaDao().insertTablicaTablica(TablicaTablica(4,5,"NK Kuzmica",22,16-3,19))
        database.tablicaDao().insertTablicaTablica(TablicaTablica(5,6,"NK Vidovci",22,16-3,19))
        database.tablicaDao().insertTablicaTablica(TablicaTablica(6,7,"NK Gradac",22,16-3,19))
        database.tablicaDao().insertTablicaTablica(TablicaTablica(7,8,"NK Mihaljevci",22,16-3,19))
        database.tablicaDao().insertTablicaTablica(TablicaTablica(8,9,"NK Buk",22,16-3,19))
        database.tablicaDao().insertTablicaTablica(TablicaTablica(9,10,"NK Trenkovo",22,16-3,19))
        database.tablicaDao().insertTablicaTablica(TablicaTablica(10,11,"NK Biškupci",22,16-3,19))
        database.tablicaDao().insertTablicaTablica(TablicaTablica(11,12,"NK Eminovci",22,16-3,19))
*/
        //database.tablicaDao().deleteTablicaTablica()

        val sveTabliceUBazi = database.tablicaDao().getTablicaTablica()

        recyclerViewTablica.apply {
            layoutManager = LinearLayoutManager(this@TablicaActivity)
            adapter = TablicaTablicaAdapter(sveTabliceUBazi)
        }

    }
}