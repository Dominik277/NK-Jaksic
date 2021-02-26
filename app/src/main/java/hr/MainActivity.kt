package hr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import hr.dominik.nkjaki.R
import hr.fragmenti.*
import hr.novoDodavanje.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val noviIgrac = DodajNovogIgraca()
    val noviRaspored = DodajNoviRasporedFragment()
    val noviRezultat = DodajNoviRezultatFragment()
    val noviRasporedLiga = DodajNoviRasporedLigaFragment()
    val noviRezultatiLiga = DodajNoviRezultatLigaFragment()
    val novaVijest = DodajNovuVijest()

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
        val tablicaFragment = TablicaFragment()


        val pokus = TablicaRasporedFragment()

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
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayoutMainActivity, tablicaFragment)
                        addToBackStack(null)
                        commit()
                        drawer.closeDrawer(GravityCompat.START)
                    }
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                true
            }
            R.id.dodajNovogIgraca -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayoutMainActivity, noviIgrac)
                    addToBackStack(null)
                    commit()
                }
                true
            }
            R.id.dodajNoviRaspored -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayoutMainActivity, noviRaspored)
                    addToBackStack(null)
                    commit()
                }
                true
            }
            R.id.dodajNoviRezultat -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayoutMainActivity, noviRezultat)
                    addToBackStack(null)
                    commit()
                }
                true
            }
            R.id.dodajTablicuRapored -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayoutMainActivity, noviRasporedLiga)
                    addToBackStack(null)
                    commit()
                }
                true
            }
            R.id.dodajTablicuRezultat -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayoutMainActivity, noviRezultatiLiga)
                    addToBackStack(null)
                    commit()
                }
                true
            }
            R.id.dodajNovuVijest -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayoutMainActivity, novaVijest)
                    addToBackStack(null)
                    commit()
                }
                true
            }
            else -> false
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
