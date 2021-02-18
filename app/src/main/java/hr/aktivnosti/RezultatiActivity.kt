package hr.aktivnosti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import hr.adapteri.RezultatAdapter
import hr.database.NKJaksicDatabase
import hr.database.table.Rezultat
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.activity_rezultati.*

class RezultatiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rezultati)
        setSupportActionBar(findViewById(R.id.toolbarRezultati))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Rezultati"

        recyclerviewRezultati.addItemDecoration(DividerItemDecoration
            (recyclerviewRezultati.context,DividerItemDecoration.VERTICAL))

        val database = Room.databaseBuilder(
            this, NKJaksicDatabase::class.java,"nk_jaksic_baza"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
/*
        database.rezultatiDao().insertRezultat(Rezultat(0,"21.02.","NK Jakšić-NK Kuzmica","4:1","P"))
        database.rezultatiDao().insertRezultat(Rezultat(1,"23.02.","NK Jakšić-NK Svačić","1:1","N"))
        database.rezultatiDao().insertRezultat(Rezultat(2,"25.02.","NK Jakšić-NK Donja Vrba","2:2","N"))
        database.rezultatiDao().insertRezultat(Rezultat(3,"27.02.","NK Jakšić-NK Trenkovo","2:1","P"))
        database.rezultatiDao().insertRezultat(Rezultat(4,"29.02.","NK Jakšić-NK Vidovci","3:1","P"))
        database.rezultatiDao().insertRezultat(Rezultat(5,"02.03.","NK Jakšić-NK Mihaljevci","1:1","I"))
        database.rezultatiDao().insertRezultat(Rezultat(6,"08.03.","NK Jakšić-NK Gradac","5:1","P"))
        database.rezultatiDao().insertRezultat(Rezultat(7,"12.03.","NK Jakšić-NK Zagrađe","3:1","P"))
        database.rezultatiDao().insertRezultat(Rezultat(8,"22.03.","NK Jakšić-NK Bučje","0:3","I"))
        database.rezultatiDao().insertRezultat(Rezultat(9,"28.03.","NK Jakšić-NK Slavija","2:2","N"))
        database.rezultatiDao().insertRezultat(Rezultat(10,"02.04.","NK Jakšić-NK Slavonija","2:1","P"))
        database.rezultatiDao().insertRezultat(Rezultat(11,"09.04.","NK Jakšić-NK Kutjevo","0:1","I"))
*/
        //database.rezultatiDao().deletePodatkeRezultat()
        val sviRezultatiUBazi = database.rezultatiDao().getRezultatData()

        recyclerviewRezultati.apply {
            layoutManager = LinearLayoutManager(this@RezultatiActivity)
            adapter = RezultatAdapter(sviRezultatiUBazi)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_novi_rezultat,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuNoviRezultat -> {
                val intent = Intent(this, NoviRezultatActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

