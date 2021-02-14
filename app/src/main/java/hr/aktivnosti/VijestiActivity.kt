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
import hr.NovaVijestActivity
import hr.adapteri.MomcadAdapter
import hr.adapteri.VijestiAdapter
import hr.database.NKJaksicDatabase
import hr.database.Vijesti
import hr.dominik.nkjaki.R
import kotlinx.android.synthetic.main.activity_momcad.*
import kotlinx.android.synthetic.main.activity_vijesti.*

class VijestiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vijesti)
        setSupportActionBar(findViewById(R.id.toolbarVijesti))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title="Vijesti"

        recyclerviewVijesti.addItemDecoration(DividerItemDecoration
            (recyclerviewVijesti.context,DividerItemDecoration.VERTICAL))

        val database = Room.databaseBuilder(
            this, NKJaksicDatabase::class.java,"nk_jaksic_baza"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        database.vijestiDao().insertVijest(Vijesti(0,"NK Jakšić pobijedio NK Kuzmicu s rezultatom 4:3",R.drawable.slikavijesti))
        database.vijestiDao().insertVijest(Vijesti(1,"NK Jakšić pobijedio NK Požegu s rezultatom 4:0",R.drawable.slikavijesti))
        database.vijestiDao().insertVijest(Vijesti(2,"NK Jakšić izgubio od NK Kaptol 0:1 ",R.drawable.slikavijesti))
        database.vijestiDao().insertVijest(Vijesti(3,"NK Jakšić remizirao s NK Dinamo Vidovci 2:2",R.drawable.slikavijesti))

        //database.vijestiDao().deletePodatkeVijesti()

        val svePohranjeneVijesti = database.vijestiDao().getVijestiData()

        recyclerviewVijesti.apply {
            layoutManager = LinearLayoutManager(this@VijestiActivity)
            adapter = VijestiAdapter(svePohranjeneVijesti)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.vijesti_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.vijestiMenu -> {
                val intent = Intent(this,NovaVijestActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}