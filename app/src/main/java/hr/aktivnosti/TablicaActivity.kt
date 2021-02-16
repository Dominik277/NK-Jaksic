package hr.aktivnosti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import hr.adapteri.TablicaTablicaAdapter
import hr.database.NKJaksicDatabase
import hr.database.TablicaTablica
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.activity_tablica.*
import kotlinx.android.synthetic.main.fragment_tablica_tablica.*

class TablicaActivity : AppCompatActivity() {

    private lateinit var recyclerview: RecyclerView
    private lateinit var adapter: TablicaTablicaAdapter

    public val database = Room.databaseBuilder(
        this, NKJaksicDatabase::class.java, "nk_jaksic_baza"
    )
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablica)
        setSupportActionBar(findViewById(R.id.toolbarTablica))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Tablica"


        database.tablicaDao()
            .insertTablicaTablica(TablicaTablica(0, 1, "NK Jakšić", 22, 34 - 22, 54))
        database.tablicaDao()
            .insertTablicaTablica(TablicaTablica(1, 2, "NK Požega", 22, 38 - 25, 50))
        database.tablicaDao()
            .insertTablicaTablica(TablicaTablica(2, 3, "NK Kuzmica", 22, 30 - 22, 44))
        database.tablicaDao()
            .insertTablicaTablica(TablicaTablica(3, 4, "NK Lipik", 22, 37 - 59, 34))
        database.tablicaDao()
            .insertTablicaTablica(TablicaTablica(4, 5, "NK Pakrac", 22, 22 - 42, 24))

        //database.tablicaDao().deleteTablicaTablica()
        val tablicaList = database.tablicaDao().getTablicaTablica()


        }
    }
}