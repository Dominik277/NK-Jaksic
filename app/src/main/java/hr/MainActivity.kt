package hr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import hr.aktivnosti.*
import hr.dominik.nkjaki.R
import hr.aktivnosti.MomcadActivity
import hr.aktivnosti.RasporedActivity
import hr.aktivnosti.RezultatiActivity
import hr.aktivnosti.VijestiActivity
import hr.pokusTablicaFragmenti.PokusTablicaActivity
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
                    val intent = Intent(this, RezultatiActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_raspored -> {
                    val intent = Intent(this, RasporedActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_tablica -> {
                    val intent = Intent(this, PokusTablicaActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_vijesti -> {
                    val intent = Intent(this, VijestiActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_momcad -> {
                    val intent = Intent(this, MomcadActivity::class.java)
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