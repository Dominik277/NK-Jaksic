package hr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import hr.dominik.nkjaki.R
import hr.aktivnosti.TablicaActivity
import hr.fragmenti.*
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


        val rasporedFragment = RasporedFragment()
        val rezultatiFragment = RezultatiFragment()
        val momcadFragment = MomcadFragment()
        val vijestiFragment = VijestiFragment()
        val pocetniFragment = PocetnaStranicaFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayoutMainActivity,pocetniFragment)
            commit()
        }

        navigation_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_rezultati -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayoutMainActivity,rezultatiFragment)
                        addToBackStack(null)
                        commit()
                        drawer.closeDrawer(GravityCompat.START)
                    }
                    true
                }
                R.id.nav_raspored -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayoutMainActivity,rasporedFragment)
                        addToBackStack(null)
                        commit()
                        drawer.closeDrawer(GravityCompat.START)
                    }
                    true
                }
                R.id.nav_tablica -> {
                    val intent = Intent(this, TablicaActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.nav_vijesti -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayoutMainActivity,vijestiFragment)
                        addToBackStack(null)
                        commit()
                        drawer.closeDrawer(GravityCompat.START)
                    }
                    true
                }
                R.id.nav_momcad -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayoutMainActivity,momcadFragment)
                        addToBackStack(null)
                        commit()
                        drawer.closeDrawer(GravityCompat.START)
                    }
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