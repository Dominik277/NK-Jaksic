package hr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.room.Room
import hr.aktivnosti.*
import hr.database.NKJaksicDatabase
import hr.dominik.nkjaki.R
import hr.pokusMomcad.PokusMomcadActivity
import hr.pokusRaspored.PokusRasporedActivity
import hr.pokusRezultati.PokusRezultatiActivity
import hr.pokusVijesti.PokusVijestiActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val drawerToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        navigation_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_rezultati -> {
                    val intent = Intent(this, PokusRezultatiActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_raspored -> {
                    val intent = Intent(this, PokusRasporedActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_tablica -> {
                    val intent = Intent(this, TablicaActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_vijesti -> {
                    val intent = Intent(this, PokusVijestiActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_momcad -> {
                    val intent = Intent(this, PokusMomcadActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


}